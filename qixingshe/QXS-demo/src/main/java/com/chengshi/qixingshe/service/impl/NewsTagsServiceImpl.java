package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.NewsTagsMapper;
import com.chengshi.qixingshe.model.NewsTags;
import com.chengshi.qixingshe.service.INewsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class NewsTagsServiceImpl extends ServiceImpl<NewsTagsMapper, NewsTags> implements INewsTagsService {
    @Autowired
    NewsTagsMapper newsTagsMapper;

    @Override
    public NewsTags findNewsTagsById(Integer id) {
        return newsTagsMapper.findById(id);
    }

    @Override
    public List<NewsTags> findNewsTagsList() {
        return newsTagsMapper.findList();
    }

    @Override
    public Page findNewsTagsPages(Query<Object> page, EntityWrapper<NewsTags> wrapper) {
        page.setSize(10);
        page.setRecords(newsTagsMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean deleteNewsTags(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        NewsTags newsTags = new NewsTags();
        newsTags.setId(id);
        wrapper.setEntity(newsTags);
        int count = newsTagsMapper.delete(wrapper);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDeleteNewsTags(List<Integer> ids) {
        int count = newsTagsMapper.deleteBatchIds(ids);
        if (count == ids.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateNewTags(NewsTags newsTag) {
        int count = newsTagsMapper.updateById(newsTag);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewsTags(NewsTags newsTags) {
        newsTags.setCreateTime(new Date());
        int count = newsTagsMapper.insert(newsTags);
        if (count == 1) {
            return true;
        }
        return false;
    }
}
