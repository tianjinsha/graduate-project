package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface INewsService extends IService<News> {

    News findNewsById(Integer id);

    List<News> findNewsList();

    Page findNewsPages(Query<Object> page, EntityWrapper<News> wrapper);

    Boolean addNews(News news);

    Boolean deleteNews(Integer id);

    /**
     *跟新新闻
     * @param news
     * @return
     */
    Boolean updateNews(News news);

    /**
     * 改变新闻状态
     * @param id
     * @param status
     * @return
     */
    Boolean changeNewsStatus(Integer id,String status);

    /**
     * 批量新闻状态
     * @param ids
     * @param status
     * @return
     */
    Boolean batchChangeNewsStatus(List<Integer> ids,String status);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean batchDeleteNews(List<Integer> ids);

}
