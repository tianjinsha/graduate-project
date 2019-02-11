package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.model.NewsTags;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface INewsTagsService extends IService<NewsTags> {
    NewsTags findNewsTagsById(Integer id);

    List<NewsTags> findNewsTagsList();

    Page findNewsTagsPages(Query<Object> page, EntityWrapper<NewsTags> wrapper);

    Boolean deleteNewsTags(Integer id);

    Boolean batchDeleteNewsTags(List<Integer> ids);

    Boolean updateNewTags(NewsTags newsTag);

    Boolean addNewsTags(NewsTags newsTags);
}
