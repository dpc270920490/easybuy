package cn.qzt.service;

import cn.qzt.pojo.EasybuyUser;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/117:00
 */
public interface TokenService {
    //生成一个token

    /**
     * 生成token
     * @param userAgent
     * @param user
     * @return
     */
    public String generateToken(String userAgent, EasybuyUser user);

    /**
     * 保存token
     * @param token
     * @param user
     */
    public void save(String token,EasybuyUser user);

    /**
     * 验证token
     * @param userAgent
     * @param token
     * @return
     */
    public Boolean validate(String userAgent,String token);

    /**
     * 替换token
     * @param userAgent
     * @param token
     * @return
     */
    public String reloadToken(String userAgent,String token) throws Exception;

    /**
     * 注销token
     * @param token
     * @return
     */
    public Boolean delToken(String token);
}
