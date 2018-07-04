package cn.qzt.service;

import cn.qzt.pojo.EasybuyOrder;
import java.util.Map;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/299:04
 */

public interface EasybuyOrderService {


    public Integer addOrder(EasybuyOrder order);



    public EasybuyOrder getOrder(EasybuyOrder order);



    public Integer upOrder(EasybuyOrder easybuyOrder);



    public EasybuyOrder getOrderByMap(String serialNumber);
}
