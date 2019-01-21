package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ItCategory;
import com.chengshi.qixingshe.model.LiveTopic;
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
public interface LiveTopicMapper extends BaseMapper<LiveTopic> {
    LiveTopic findById(Integer id);

    List<LiveTopic> findList();

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
