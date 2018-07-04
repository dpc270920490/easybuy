package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyOrderMapper;
import cn.qzt.pojo.EasybuyOrder;
import cn.qzt.service.EasybuyOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/299:06
 */
@Service
public class EasybuyOrderServiceImpl implements EasybuyOrderService {
    @Resource
    private EasybuyOrderMapper orderMapper;


    public Integer addOrder(EasybuyOrder order) {
        return orderMapper.addOrder(order);
    }

    public EasybuyOrder getOrder(EasybuyOrder order) {
        return orderMapper.getOrder(order);
    }

    public Integer upOrder(EasybuyOrder easybuyOrder) {
        return orderMapper.upOrder(easybuyOrder);
    }

    public EasybuyOrder getOrderByMap(String serialNumber) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("serialNumber",serialNumber);
        List<EasybuyOrder> orderList = orderMapper.getOrderbyMap(map);
        if(orderList.size()>0){

            return orderList.get(0);

        }
        return null;
    }
}
