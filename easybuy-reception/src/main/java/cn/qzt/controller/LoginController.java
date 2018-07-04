package cn.qzt.controller;

import cn.qzt.pojo.EasybuyNews;
import cn.qzt.pojo.EasybuyProductCategory;
import cn.qzt.pojo.EasybuyUser;
import cn.qzt.service.EasybuyNewsService;
import cn.qzt.service.EasybuyProductCategoryService;
import cn.qzt.service.EasybuyUserService;
import cn.qzt.utils.Constant;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2510:28
 */
@Controller
public class LoginController {
    /**
     * 用户类
     */
    @Resource
    private EasybuyUserService easybuyUserService;
    /**
     * 品种类
     */
    @Resource
    private EasybuyProductCategoryService categoryService;
    /**
     * 新闻类
     */
    @Resource
    private EasybuyNewsService newsService;







    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/main")
    public String main(HttpServletRequest request, Model model){
        List<EasybuyProductCategory> category = categoryService.getCategory();
        model.addAttribute("categoryList",category);
        List<EasybuyNews> news = newsService.getNewsList(Constant.newsCount);
        model.addAttribute("newsList",news);
        return "main";

    }
    @RequestMapping(value = "/logto")
    public String logto(@RequestParam String userName, @RequestParam String password,
                        HttpServletRequest request, HttpSession session){
        EasybuyUser user = easybuyUserService.getUserByLoginName(userName);

        String pas = DigestUtils.md5Hex(password);


        if(user==null){
            request.setAttribute(Constant.ERROR_MESSAGE,"用户名不存在！");

            return "login";


        }else if(!user.getPassword().equals(pas)){




            request.setAttribute(Constant.ERROR_MESSAGE,"密码输入错误！");

            return "login";
        }

        session.setAttribute(Constant.USER_SESSION,user);
        return "redirect:/main";
    }



    @RequestMapping("/register")
    public String register(){





        return "register";
    }

    @RequestMapping("/registerTo")
    public String registerTo(EasybuyUser user,Model model){
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));

            System.out.println(user.getLoginName());
        System.out.println(user.getPassword());
          Integer result =   easybuyUserService.addUser(user);
            if(result>0){


                return "redirect:/main";

            }
            model.addAttribute(Constant.ERROR_MESSAGE,"注册失败！");

            return "/register";

    }




}
