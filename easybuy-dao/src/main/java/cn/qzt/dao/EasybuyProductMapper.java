package cn.qzt.dao;

import cn.qzt.pojo.EasybuyProduct;
import cn.qzt.pojo.ProductPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/268:32
 */
public interface EasybuyProductMapper {
    /**
     * 分页查询商品
     * @param start
     * @param size
     * @return
     */
    public List<EasybuyProduct> getProductList(@Param("pageStart")Integer start,@Param("pageSize") Integer size);

    /**
     * 获取商品数量
     * @return
     */
    public Integer getProductCount();


    /**
     * 查询特定条件的新闻数量
     * @param productPage
     * @return
     */
    public Integer getCondition(@Param("page") ProductPage productPage);
    /**
     * 根据筛选条件查询
     * @param productPage
     * @return
     */
    public List<EasybuyProduct> getProductByCondition(@Param("page")ProductPage productPage);


    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    public EasybuyProduct getProduct(@Param("id") Integer id);

}
