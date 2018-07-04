package cn.qzt.service;

import cn.qzt.pojo.EasybuyNews;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2518:08
 */
public interface EasybuyNewsService {
    public List<EasybuyNews> getNewsList(Integer count);

    public Integer getNewsCount();

    public List<EasybuyNews> getNews(Integer pageStar,Integer pageSize);

}
