package cn.qzt.controller;

import cn.qzt.service.EasybuyProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2516:39
 */
@Controller
@RequestMapping(value = "/category")
public class EasybuyProductCategoryController {
    @Resource
    private EasybuyProductCategoryService categoryService;

    public String getCategory(){




        return null;
    }

}
