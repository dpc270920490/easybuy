package cn.qzt.dao;

import cn.qzt.pojo.EasybuyNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/6/2518:00
 */
public interface EasybuyNewsMapper {
    /**
     * 根据显示新闻条数查询新闻　
     * @param count
     * @return
     */
    public List<EasybuyNews> getNewsList(@Param("count") Integer count);

    /**
     * 分页查询新闻
     * @param pageStar
     * @param pageSize
     * @return
     */
    public List<EasybuyNews> getNewsCounts(@Param("pageStar") Integer pageStar,@Param("pageSize") Integer pageSize);

    /**
     * 查询新闻总数
     * @return
     */
    public Integer getNewsCount();


}
