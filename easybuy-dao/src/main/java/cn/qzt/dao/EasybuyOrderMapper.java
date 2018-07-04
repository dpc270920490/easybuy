package cn.qzt.dao;

import cn.qzt.pojo.EasybuyOrder;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/298:54
 */
public interface EasybuyOrderMapper {
    /**
     * 添加订单
     * @param easybuyOrder
     * @return
     */
    public Integer addOrder(@Param("order")EasybuyOrder easybuyOrder);

    /**
     * 查找订单
     * @param easybuyOrder
     * @return
     */
    public EasybuyOrder getOrder(@Param("order") EasybuyOrder easybuyOrder);

    /**
     * 修改订单
     * @param easybuyOrder
     * @return
     */
    public Integer upOrder(@Param("order") EasybuyOrder easybuyOrder);

    /**
     * 根据map查询订单
     * @param map
     * @return
     */
    public List<EasybuyOrder> getOrderbyMap(Map<String,Object> map);

}
