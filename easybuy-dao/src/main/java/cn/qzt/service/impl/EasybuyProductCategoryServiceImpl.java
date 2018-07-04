package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyProductCategoryMapper;
import cn.qzt.pojo.EasybuyProductCategory;
import cn.qzt.service.EasybuyProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2516:37
 */
@Service
public class EasybuyProductCategoryServiceImpl implements EasybuyProductCategoryService {
   @Resource
   private EasybuyProductCategoryMapper categoryMapper;

    public List<EasybuyProductCategory> getCategory() {
        return categoryMapper.getCategory();
    }
}
