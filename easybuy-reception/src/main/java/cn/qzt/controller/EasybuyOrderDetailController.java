package cn.qzt.controller;

import cn.qzt.pojo.*;
import cn.qzt.service.EasybuyOrderDetailService;
import cn.qzt.service.EasybuyOrderService;
import cn.qzt.service.EasybuyProductService;
import cn.qzt.service.EasybuyUserAddressService;
import cn.qzt.utils.Constant;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2819:42
 */
@Controller
@RequestMapping(value = "/detail")
public class EasybuyOrderDetailController {
    @Resource
    private EasybuyOrderDetailService detailService;
    @Resource
    private EasybuyProductService productService;
    @Resource
    private EasybuyOrderService orderService;
    @Resource
    private EasybuyUserAddressService addressService;

    @RequestMapping("/add")
    @ResponseBody
    public Object addDetail(@RequestParam Integer id, HttpServletRequest request, HttpSession session){

        if(session.getAttribute(Constant.USER_SESSION)==null){


            return "login";


        }


        EasybuyUser user = (EasybuyUser) session.getAttribute(Constant.USER_SESSION);


        System.out.println("进来了－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");


        EasybuyProduct product = productService.getProduct(id);

        EasybuyOrder order = new EasybuyOrder();
        order.setUserId(user.getId());
        order.setIsPlace(0);
        EasybuyOrder buyOrder = orderService.getOrder(order);
        if(buyOrder == null){
            order.setCreateTime(new Date());
            //生成订单号
            order.setCost(product.getPrice());
            String serialNumber = System.currentTimeMillis()+RandomUtils.nextInt(1000,100000000) + user.getLoginName();
            order.setSerialNumber(serialNumber);
            List<EasybuyUserAddress> userAddress = addressService.getUserAddress(user.getId());

            if(userAddress.size()>0) {
                for (EasybuyUserAddress address : userAddress) {
                    if (address.getIsDefault() == 1) {

                        order.setUserAddress(address.getAddress());

                    }

                }
            }else {

                order.setUserAddress(null);


            }


            order.setLoginName(user.getLoginName());
            orderService.addOrder(order);
            EasybuyOrderDetail orderDetail = new EasybuyOrderDetail();
            orderDetail.setProductId(id);
            orderDetail.setQuantity(1);
            orderDetail.setCost(product.getPrice());

            EasybuyOrder orderByuser = orderService.getOrder(order);
            orderDetail.setOrderId(orderByuser.getId());
            Integer da = detailService.addOrder(orderDetail);
            if(da>0){
                return "succeed";
            }else {
                return "failed";
            }
        }else if(buyOrder != null){

            EasybuyOrderDetail orderDetail = new EasybuyOrderDetail();
            Integer sum = Integer.parseInt(buyOrder.getCost())+Integer.parseInt(product.getPrice());
            buyOrder.setCost(sum.toString());
            System.out.println(buyOrder.getId());

            //修改购物车的总价格
            orderService.upOrder(buyOrder);



            orderDetail.setProductId(id);

            orderDetail.setQuantity(1);
            orderDetail.setCost(product.getPrice());
            orderDetail.setOrderId(buyOrder.getId());
            Integer da = detailService.addOrder(orderDetail);
            if(da>0){
                return "succeed";
            }else {
                return "failed";
            }



        }

        return "error";
    }

    @RequestMapping("/bayCar")
    public String bayCarIn(HttpSession session, HttpServletRequest request, Model model){
        if(session.getAttribute(Constant.USER_SESSION)==null){



            request.setAttribute(Constant.SYS_MESSAGE,"请先登录！");


            return "/login";




        }

        EasybuyUser user = (EasybuyUser) session.getAttribute(Constant.USER_SESSION);

        List<BuyCar> buyCarList = detailService.getBuyCar(user.getId());

        EasybuyOrder order1 = new EasybuyOrder();
        order1.setUserId(user.getId());
        order1.setIsPlace(0);
        EasybuyOrder order = orderService.getOrder(order1);

        model.addAttribute("buyCarList",buyCarList);
        model.addAttribute("order",order);






        return "buyCar";
    }

}
