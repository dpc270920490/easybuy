package cn.qzt.service.impl;

import cn.qzt.dao.EasybuyNewsMapper;
import cn.qzt.pojo.EasybuyNews;
import cn.qzt.service.EasybuyNewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2518:09
 */
@Service
public class EasybuyNewsServiceImpl implements EasybuyNewsService {
    @Resource
    private EasybuyNewsMapper newsMapper;

    public List<EasybuyNews> getNewsList(Integer count) {
        return newsMapper.getNewsList(count);
    }

    public Integer getNewsCount() {
        return newsMapper.getNewsCount();
    }

    public List<EasybuyNews> getNews(Integer pageStar,Integer pageSize) {
        return newsMapper.getNewsCounts(pageStar,pageSize);
    }
}
