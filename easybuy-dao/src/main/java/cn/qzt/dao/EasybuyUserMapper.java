package cn.qzt.dao;

import cn.qzt.pojo.EasybuyUser;
import org.apache.ibatis.annotations.Param;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2510:01
 */
public interface EasybuyUserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public EasybuyUser getUserById(@Param("id") Integer id);

    /**
     * 根据登录名查询用户
     * @param name
     * @return
     */
    public EasybuyUser getUserByLoginName(@Param("name")String name);

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer addUser(@Param("user") EasybuyUser user);




}
