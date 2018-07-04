package cn.qzt.service;

import cn.qzt.pojo.BuyCar;
import cn.qzt.pojo.EasybuyOrder;
import cn.qzt.pojo.EasybuyOrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2820:04
 */
public interface EasybuyOrderDetailService {

    public Integer addOrder(EasybuyOrderDetail orderDetail);

    public List<EasybuyOrderDetail> getOrderDetail(Integer orderId );

    public List<BuyCar> getBuyCar(Integer userId);

}
