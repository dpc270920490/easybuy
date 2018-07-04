package cn.qzt.controller;

import cn.qzt.pojo.EasybuyNews;
import cn.qzt.service.EasybuyNewsService;
import cn.qzt.utils.Constant;
import cn.qzt.utils.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2518:12
 */
@Controller
public class EasybuyNewsController {
    @Resource
    EasybuyNewsService newsService;

    @RequestMapping("/newsList")
    public String newsList(@RequestParam(value = "pageNo",required = false) Integer pageNo, Model model){
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(Constant.pageSize);
        if(pageNo==null){
            pageSupport.setCurrentPageNo(1);
        }else {
            pageSupport.setCurrentPageNo(pageNo);
        }
        Integer totalCount = newsService.getNewsCount();
        pageSupport.setTotalCount(totalCount);
        List<EasybuyNews> newsList = newsService.getNews((pageSupport.getCurrentPageNo()-1)*pageSupport.getPageSize(),pageSupport.getPageSize());
        model.addAttribute("newsList",newsList);
        model.addAttribute("totalPageCount",pageSupport.getTotalPageCount());
        System.out.println(pageSupport.getTotalPageCount());
        return "newList";
    }

}
