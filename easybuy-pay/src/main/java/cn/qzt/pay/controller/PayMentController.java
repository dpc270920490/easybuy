package cn.qzt.pay.controller;

import cn.qzt.pay.config.AlipayConfig;
import cn.qzt.pojo.EasybuyOrder;
import cn.qzt.service.EasybuyOrderService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/216:28
 */
@Controller
@RequestMapping("/pay")
public class PayMentController {
    @Resource
    private EasybuyOrderService orderService;
    //订单确认
    @Resource
    private AlipayConfig alipayConfig;
    /**
     *
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "/verify/{orderNo}")
    public String order(@PathVariable String orderNo, ModelMap modelMap){
        EasybuyOrder order = orderService.getOrderByMap(orderNo);
        if(order!=null){

            modelMap.addAttribute("serialNumber",order.getSerialNumber());
            modelMap.addAttribute("cost",order.getCost());
            modelMap.addAttribute("userAddress",order.getUserAddress());



        }
        return "error";

    }


    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public void pay(@RequestParam String out_trade_no, @RequestParam String subject, @RequestParam String total_amount,
                      HttpServletResponse response){



    //订单提交支付宝
// 商户订单号，商户网站订单系统中唯一订单号，必填
//    String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//    // 订单名称，必填
//    String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
//	System.out.println(subject);
//    // 付款金额，必填
//    String total_amount=new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
//    // 商品描述，可空
//    String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
//    // 超时时间 可空
    String timeout_express="2m";
    // 销售产品码 必填
    String product_code="QUICK_WAP_PAY";
    /**********************/
    // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
    //调用RSA签名方式
    AlipayClient client = new DefaultAlipayClient(alipayConfig.getUrl(), alipayConfig.getAppId(), alipayConfig.getRsaPrivateKey(), alipayConfig.getFormat(), alipayConfig.getCharset(), alipayConfig.getAlipayPublicKey(),alipayConfig.getSignType());
    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

    // 封装请求支付信息
    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
    //订单号
    model.setOutTradeNo(out_trade_no);
    // 商品名称
    model.setSubject(subject);
    //订单金额
    model.setTotalAmount(total_amount);

    model.setTimeoutExpress(timeout_express);
    model.setProductCode(product_code);
    alipay_request.setBizModel(model);
    // 设置异步通知地址
    alipay_request.setNotifyUrl(alipayConfig.getNotifyUrl());
    // 设置同步地址
    alipay_request.setReturnUrl(alipayConfig.getReturnUrl());

    // form表单生产
    String form = "";
	try {
        // 调用SDK生成表单
        form = client.pageExecute(alipay_request).getBody();
        response.setContentType("text/html;charset=" + alipayConfig.getCharset());
        response.getWriter().write(form);
        //直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    } catch (AlipayApiException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    //支付宝回调

    //notify
    @RequestMapping(value = "/notify",method = RequestMethod.POST)
    public void notify(HttpServletResponse response, HttpServletRequest request){
        //获取支付宝POST过来反馈信息
        try {
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        boolean verify_result = false;
        //商户订单号

            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)


            verify_result = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), "RSA2");

        if(verify_result){
           //验证成功
           //请在这里加上商户的业务逻辑程序代码

            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            } else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            }

            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            response.getWriter().println("success");
            //请不要修改或删除

            //////////////////////////////////////////////////////////////////////////////////////////
        }else{//验证失败
            response.getWriter().println("fail");
        }

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //return

    public String returnUrl(HttpServletRequest request,HttpServletResponse response){
        //获取支付宝GET过来反馈信息

        try {
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = false;

            verify_result = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), "RSA2");


        if(verify_result){//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码
            //该页面可做页面美工编辑
            response.sendRedirect(alipayConfig.getPaySuccessUrl());
            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            //////////////////////////////////////////////////////////////////////////////////////////
        }else{
            //该页面可做页面美工编辑
            response.sendRedirect(alipayConfig.getPayFailureUrl());
        }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
