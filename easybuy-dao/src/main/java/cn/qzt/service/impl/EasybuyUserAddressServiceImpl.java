package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyUserAddressMapper;
import cn.qzt.pojo.EasybuyUserAddress;
import cn.qzt.service.EasybuyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2910:58
 */
@Service
public class EasybuyUserAddressServiceImpl implements EasybuyUserAddressService {
    @Resource
    private EasybuyUserAddressMapper addressMapper;


    public List<EasybuyUserAddress> getUserAddress(Integer id) {
        return addressMapper.getUserAddress(id);
    }
}
