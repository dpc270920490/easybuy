package cn.qzt.dao;

import cn.qzt.pojo.BuyCar;
import cn.qzt.pojo.EasybuyOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2819:56
 */
public interface EasybuyOrderDetailMapper {
    /**
     * 增加订单到购物车
     */
    public Integer addOrder(@Param("order")EasybuyOrderDetail orderDetail);

    /**
     * 根据用户id查询订单详细信息
     * @param id
     * @return
     */
    public List<EasybuyOrderDetail> gteOrderDetail(@Param("id") Integer id);

    /**
     * 根据主订单id查询详细订单信息
     * @param userId
     * @return
     */
    public List<BuyCar> getBuyCarList(@Param("userId") Integer userId);


}
