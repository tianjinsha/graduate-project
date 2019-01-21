package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.model.NewsCategory;
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
public interface INewsCategoryService extends IService<NewsCategory> {

    NewsCategory findNewsCategoryById(Integer id);

    List<NewsCategory> findNewsCategoryList();

    Page findNewsCategoryPages(Query<Object> page, EntityWrapper<NewsCategory> wrapper);

    public Boolean addNesCaregory(NewsCategory newsCategory);

    public Boolean deleteNewsCategory(Integer id);

    public Boolean updateNewsCategory(NewsCategory newsCategory);

    public Boolean batchDeleteNewsCategory(List<Integer> ids);
}
