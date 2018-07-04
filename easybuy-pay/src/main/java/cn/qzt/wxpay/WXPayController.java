package cn.qzt.wxpay;

import cn.qzt.service.EasybuyOrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import cn.qzt.utils.WXpay.WXPayConstants;
import cn.qzt.utils.WXpay.WXPayRequest;
import cn.qzt.utils.WXpay.WXPayUtil;
import com.sun.javafx.collections.MappingChange;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/310:18
 */
@RequestMapping("/wxPay")
public class WXPayController {
    @Resource
    private EasybuyOrderService orderService;

    /**
     * 统一下单接口
     * @param out_trade_no
     * @return
     */
    @RequestMapping("/create/{out_trade_no}")
    @ResponseBody
    public Object createCode(@PathVariable String out_trade_no){

        //封装数据
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
        data.put("nonce_str",WXPayUtil.generateNonceStr());
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");

        data.put("appid", "wxab8acb865bb1637e");
        data.put("mch_id", "11473623");
        //封装签名　指定加密方式　当加密形式为MD5时可以不加！
        data.put("sign_type","HMAC-SHA256");

        //将数据转换为XML类型
        try {
            String reqXML = WXPayUtil.generateSignedXml(data,"2ab9071b06b9f739b950ddb41db2690d",WXPayConstants.SignType.HMACSHA256);


            //接收返回的xml数据
            String respXMl = WXPayRequest.requestwx("https://api.mch.weixin.qq.com/pay/unifiedorder",reqXML);

            //判断是否成功
            Map<String,String> resultMap = WXPayUtil.xmlToMap(reqXML);

            if(resultMap.get("return_code").equals("SUCCESS")&&resultMap.get("result_code").equals("SUCCESS")){
                Map<String,String> result = WXPayUtil.xmlToMap(reqXML);
                result.put("code_url",resultMap.get("code_url"));

                return result;
            }else {

                return resultMap.get("return_msg");


            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    @RequestMapping("/notify")
    public void notify(HttpServletRequest request){
        //从请求中获取对象流
        try {
            StringBuilder sb = new StringBuilder();
            InputStream inputStream = request.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));

            String temp;
            while ((temp = reader.readLine())!=null){
                sb.append(temp);

            }
            reader.close();
            inputStream.close();
            Map<String,String> map = WXPayUtil.xmlToMap(sb.toString());
            //验证返回的XML格式是否正确，确保与上传的签名一致
            boolean flag = WXPayUtil.isSignatureValid(map,"2ab9071b06b9f739b950ddb41db2690d",WXPayConstants.SignType.HMACSHA256);
            if(flag){




            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
