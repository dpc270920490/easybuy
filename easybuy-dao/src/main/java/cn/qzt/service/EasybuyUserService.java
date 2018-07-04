package cn.qzt.service;

import cn.qzt.pojo.EasybuyUser;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2510:22
 */
public interface EasybuyUserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public EasybuyUser getUserById(Integer id);
    /**
     * 根据登录名查询用户
     * @param loginName
     * @return
     */
    public EasybuyUser getUserByLoginName(String loginName);

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer addUser(EasybuyUser user);
}
