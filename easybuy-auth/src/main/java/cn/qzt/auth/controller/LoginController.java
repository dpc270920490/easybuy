package cn.qzt.auth.controller;

import cn.qzt.pojo.EasybuyUser;
import cn.qzt.service.EasybuyUserService;
import cn.qzt.service.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Resource
    private TokenService tokenService;
    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam String userName,@RequestParam String passWord, HttpServletRequest request, HttpServletResponse response) throws Exception {
        EasybuyUser user = userService.gteUserByName(userName,passWord);
        if(user==null){

          throw new Exception("输入错误！");

        }
        String userAgent = request.getHeader("userAgent");
        String token = tokenService.generateToken(userAgent,user);
        tokenService.save(token,user);
        response.setHeader("token",token);
        return token;
    }


}
