package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.NewsCategory;
import com.chengshi.qixingshe.dao.NewsCategoryMapper;
import com.chengshi.qixingshe.service.INewsCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements INewsCategoryService {
    @Autowired
    NewsCategoryMapper newsCategoryMapper;

    @Override
    public NewsCategory findNewsCategoryById(Integer id) {
        return newsCategoryMapper.findById(id);
    }

    @Override
    public List<NewsCategory> findNewsCategoryList() {
        return newsCategoryMapper.findList();
    }

    @Override
    public Page findNewsCategoryPages(Query<Object> page, EntityWrapper<NewsCategory> wrapper) {
        page.setSize(10);
        page.setRecords(newsCategoryMapper.findPage(page,page.getCondition()));
        return page;
    }

    @Override
    public Boolean addNesCaregory(NewsCategory newsCategory) {
        int count=newsCategoryMapper.insert(newsCategory);
        if(count==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteNewsCategory(Integer id) {
        EntityWrapper wrapper=new EntityWrapper();
        NewsCategory newsCategory=new NewsCategory();
        newsCategory.setId(id);
        wrapper.setEntity(newsCategory);
        int count=newsCategoryMapper.delete(wrapper);
        if(count==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateNewsCategory(NewsCategory newsCategory) {
        int count=newsCategoryMapper.updateById(newsCategory);
        if(count==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDeleteNewsCategory(List<Integer> ids) {
        int count=newsCategoryMapper.deleteBatchIds(ids);
        if(count==ids.size()){
            return true;
        }
        return false;
    }
}
