package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import com.chengshi.qixingshe.model.NewsCategory;
import com.chengshi.qixingshe.model.NewsTags;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface NewsTagsMapper extends BaseMapper<NewsTags> {
    NewsTags findById(Integer id);

    List<NewsTags> findList();

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
