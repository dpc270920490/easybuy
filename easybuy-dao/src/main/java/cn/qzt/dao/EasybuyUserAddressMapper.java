package cn.qzt.dao;

import cn.qzt.pojo.EasybuyUserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2910:51
 */
public interface EasybuyUserAddressMapper {

    public List<EasybuyUserAddress> getUserAddress(@Param("id") Integer id);


}
