package cn.qzt.service.impl;

import cn.qzt.pojo.EasybuyUser;
import cn.qzt.service.TokenService;
import cn.qzt.utils.JedisAPI;
import com.alibaba.fastjson.JSON;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/117:10
 */
@Service
public class TokenServiceImpl implements TokenService {

@Resource
private JedisAPI jedisAPI;

    /**
     * 生成token
     * @param userAgent
     * @param user
     * @return
     */
    public String generateToken(String userAgent, EasybuyUser user) {
        StringBuilder str = new StringBuilder();
        str.append("token:");
        UserAgent agent = UserAgent.parseUserAgentString(userAgent);


       //判断是否为PC端客户
        if(agent.getOperatingSystem().isInUserAgentString(userAgent)){
            str.append("MOBILE-");




        }else {

            str.append("pc-");
            str.append(DigestUtils.md5(user.getLoginName())+"-");
            str.append(user.getId().toString()+"-");
            str.append(new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date())+"-");
            str.append(DigestUtils.md5(userAgent));
            return str.toString();
        }
        return null;
    }

    /**
     * 保存token
     * @param token
     * @param user
     */
    public void save(String token, EasybuyUser user) {
        if(token.startsWith("taken:PC-")){

            jedisAPI.set(token,2*60*60, JSON.toJSONString(user));


        }else {

            jedisAPI.set(token,JSON.toJSONString(user));

        }





    }

    /**
     * 验证token
     * @param userAgent
     * @param token
     * @return
     */
    public Boolean validate(String userAgent, String token) {


        if (!jedisAPI.exists(token)){
            return false;
        }else {

            String agent = token.split("-")[4];

            if(!agent.equals(DigestUtils.md5(userAgent))){
                return false;
            }

        }



        return true;
    }

    /**
     * 替换token
     */
    private long protectedTime = 30 * 60 * 1000;
    public String reloadToken(String userAgent, String token) throws Exception {
        if(jedisAPI.exists(token)){
            throw new Exception("token无效!");
        }
        long passed = Calendar.getInstance().getTimeInMillis() - new SimpleDateFormat("yyyyMMddHHmmsss").parse(token.split("-")[3]).getTime();
        if(passed<protectedTime){
            throw new Exception("token保护期内，无法置换！");
        }

        //取出user对象
        EasybuyUser user = JSON.parseObject(jedisAPI.get(token),EasybuyUser.class);
        //生成新token
        String newToken = this.generateToken(userAgent,user);

        //将老token设置延时过期
        jedisAPI.set(token,2*60,JSON.toJSONString(user));


        //保存新token
        this.save(newToken,user);
        return newToken;
    }

    /**
     * 退出，销毁token
     * @param token
     * @return
     */
    public Boolean delToken(String token) {

        jedisAPI.del(token);
        return true;
    }
}
