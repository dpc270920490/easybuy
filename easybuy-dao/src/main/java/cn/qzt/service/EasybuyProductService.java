package cn.qzt.service;

import cn.qzt.pojo.EasybuyProduct;
import cn.qzt.pojo.ProductPage;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/268:39
 */
public interface EasybuyProductService {
    public List<EasybuyProduct> getProductList(Integer pageStart,Integer pageSize);


    public Integer getProductCount();

    public Integer getCondition(ProductPage productPage);


    public List<EasybuyProduct> getProductByCondition(ProductPage productPage);

    public EasybuyProduct getProduct(Integer id);
}
