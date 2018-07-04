package cn.qzt.service.impl;


import cn.qzt.dao.EasybuyProductMapper;
import cn.qzt.pojo.EasybuyProduct;
import cn.qzt.pojo.ProductPage;
import cn.qzt.service.EasybuyProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/268:40
 */
@Service
public class EasybuyProductServiceImpl  implements EasybuyProductService {
    @Resource
    private EasybuyProductMapper productMapper;

    public List<EasybuyProduct> getProductList(Integer pageStart,Integer pageSize) {
        return productMapper.getProductList(pageStart,pageSize);
    }

    public Integer getProductCount() {
        return productMapper.getProductCount();
    }

    public Integer getCondition(ProductPage productPage) {
        return productMapper.getCondition(productPage);
    }

    public List<EasybuyProduct> getProductByCondition(ProductPage productPage) {
        return productMapper.getProductByCondition(productPage);
    }

    public EasybuyProduct getProduct(Integer id) {
        return productMapper.getProduct(id);
    }
}
