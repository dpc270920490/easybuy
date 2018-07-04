package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyUserMapper;
import cn.qzt.pojo.EasybuyUser;
import cn.qzt.service.EasybuyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2510:24
 */
@Service
public class EasybuyUserImpl implements EasybuyUserService {
    @Resource
    private EasybuyUserMapper userMapper;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public EasybuyUser getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public EasybuyUser getUserByLoginName(String loginName) {
        return userMapper.getUserByLoginName(loginName);
    }

    public Integer addUser(EasybuyUser user) {
        return userMapper.addUser(user);
    }
}
