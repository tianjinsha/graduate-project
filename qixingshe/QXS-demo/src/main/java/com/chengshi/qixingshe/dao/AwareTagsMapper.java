package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareTags;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface AwareTagsMapper extends BaseMapper<AwareTags> {
    AwareTags findById(Integer id);

    List<AwareTags> findList();

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
