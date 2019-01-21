package com.chengshi.fitness.dao;

import com.chengshi.fitness.model.CardHistory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.fitness.util.Query;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  办卡记录 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface CardHistoryMapper extends BaseMapper<CardHistory> {

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
