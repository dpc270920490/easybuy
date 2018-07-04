package cn.qzt.auth.controller;

import cn.qzt.service.EasybuyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/413:09
 */
@Controller
@RequestMapping("/auth")
public class LoginController {
    @Resource
    private EasybuyUserService userService;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam String userName,@RequestParam String passWord, HttpServletRequest request, HttpServletResponse response){







        return null;
    }








}
