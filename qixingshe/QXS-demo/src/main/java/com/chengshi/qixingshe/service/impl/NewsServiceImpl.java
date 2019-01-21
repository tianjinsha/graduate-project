package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.NewsMapper;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public News findNewsById(Integer id) {
        return newsMapper.findById(id);
    }

    @Override
    public List<News> findNewsList() {
        return newsMapper.findList();
    }

    @Override
    public Page findNewsPages(Query<Object> page, EntityWrapper<News> wrapper) {
        page.setSize(10);
        page.setRecords(newsMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean addNews(News news) {
        int count = newsMapper.insert(news);
        if (count == 0)
            return true;
        return false;
    }

    @Override
    public Boolean deleteNews(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        News news = new News();
        news.setId(id);
        wrapper.setEntity(news);
        int count = newsMapper.delete(wrapper);
        if (count == 0)
            return true;
        return false;
    }

    @Override
    public Boolean updateNews(News news) {
        int count = newsMapper.updateById(news);
        if (count == 0)
            return true;
        return false;
    }

    @Override
    public Boolean changeNewsStatus(Integer id, String status) {
        News news = new News();
        news.setId(id);
        news.setStatus(status);
        int count = newsMapper.updateById(news);
        if (count == 0)
            return true;
        return false;
    }

    @Override
    public Boolean batchChangeNewsStatus(List<Integer> ids, String status) {
        int count = newsMapper.batchChangeStatus(ids, status);
        if (count == ids.size())
            return true;
        return false;
    }

    @Override
    public Boolean batchDeleteNews(List<Integer> ids) {
        int count = newsMapper.deleteBatchIds(ids);
        if (count == ids.size())
            return true;
        return false;
    }
}
