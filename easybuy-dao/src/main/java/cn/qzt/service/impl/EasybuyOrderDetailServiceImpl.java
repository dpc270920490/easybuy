package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyOrderDetailMapper;
import cn.qzt.pojo.BuyCar;
import cn.qzt.pojo.EasybuyOrderDetail;
import cn.qzt.service.EasybuyOrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2820:05
 */
@Service
public class EasybuyOrderDetailServiceImpl implements EasybuyOrderDetailService {
@Resource
private EasybuyOrderDetailMapper detailMapper;


    public Integer addOrder(EasybuyOrderDetail orderDetail) {
        return detailMapper.addOrder(orderDetail);
    }

    public List<EasybuyOrderDetail> getOrderDetail(Integer orderId) {
        return detailMapper.gteOrderDetail(orderId);
    }

    public List<BuyCar> getBuyCar(Integer userId) {
        return detailMapper.getBuyCarList(userId);
    }
}
