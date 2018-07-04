package cn.qzt.dao;

import cn.qzt.pojo.EasybuyProductCategory;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2516:27
 */
public interface EasybuyProductCategoryMapper {
    /**
     * 获取所有分类
     * @return
     */
    public List<EasybuyProductCategory> getCategory();




}
