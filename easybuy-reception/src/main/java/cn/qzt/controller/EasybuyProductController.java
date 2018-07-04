package cn.qzt.controller;
import cn.qzt.pojo.EasybuyProduct;
import cn.qzt.pojo.EasybuyProductCategory;
import cn.qzt.pojo.ProductPage;
import cn.qzt.service.EasybuyProductCategoryService;
import cn.qzt.service.EasybuyProductService;
import cn.qzt.utils.Constant;
import cn.qzt.utils.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/268:43
 */
@Controller
public class EasybuyProductController {
    @Resource
    private EasybuyProductService productService;
    @Resource
    private EasybuyProductCategoryService categoryService;


    @RequestMapping(value = "/productList")
    public String productList(@RequestParam(value = "pageNo",required = false) Integer pageNo, Model model){
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(Constant.PRODUCTPAGESIZE);
        if(pageNo==null){
            pageSupport.setCurrentPageNo(1);
        }else {
            pageSupport.setCurrentPageNo(pageNo);
        }


        int totalCount = productService.getProductCount();

        pageSupport.setTotalCount(totalCount);


        List<EasybuyProduct> productList = productService.getProductList((pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize(),pageSupport.getPageSize());


        model.addAttribute("pageCount",pageSupport.getTotalPageCount());


        List<EasybuyProductCategory> categoryList = categoryService.getCategory();

        model.addAttribute("productList",productList);
        model.addAttribute("categoryList",categoryList);
        return "productList";
    }

    @RequestMapping(value = "/productListPage")
    @ResponseBody
    public Object getProduct(@RequestParam Integer pageNo){

        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(Constant.PRODUCTPAGESIZE);
        if(pageNo==null){
            pageSupport.setCurrentPageNo(1);
        }else {
            pageSupport.setCurrentPageNo(pageNo);
        }
        System.out.println("我进来了－－－－－－－－－－－－－－－－－－－－－－－－");

        int totalCount = productService.getProductCount();

        pageSupport.setTotalCount(totalCount);


        List<EasybuyProduct> productList = productService.getProductList((pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize(),pageSupport.getPageSize());

        return productList;
    }
    @ResponseBody
    @RequestMapping("/getProducts")
    public Object getProducts(@RequestBody ProductPage productPage){

        System.out.println("金来－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println(productPage.getPriceLow()+"---------------------------------");
        System.out.println(productPage.getPriceTall()+"--------------------------------");
        System.out.println(productPage.getCategory()+"---------------------------------");


        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(Constant.PRODUCTPAGESIZE);
        if(productPage.getPageNo() == null || productPage.getPageNo().equals("") ||productPage.getPageNo() == 0){
            pageSupport.setCurrentPageNo(1);
        }else {
            pageSupport.setCurrentPageNo(productPage.getPageNo());
        }
        int count = productService.getCondition(productPage);
        pageSupport.setTotalCount(count);
        productPage.setPageSize(pageSupport.getPageSize());
        productPage.setPageStart((pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize());
        if(productPage.getCategory().equals("")){
            productPage.setCategory(null);
        }
        List<EasybuyProduct> productList = productService.getProductByCondition(productPage);
        return productList;
    }


//    @RequestMapping(value = "/demo")
//    @ResponseBody
//    public Object demo(@RequestBody User name){
//
//        System.out.println("demo-----------------------------");
////        System.out.println(user.getName());
////        System.out.println(user.getAge());
//        System.out.println(name.getName()+"---------------------------------------");
//        User user = new User();
//        user.setName("");
//
//        return user;
//    }

}
