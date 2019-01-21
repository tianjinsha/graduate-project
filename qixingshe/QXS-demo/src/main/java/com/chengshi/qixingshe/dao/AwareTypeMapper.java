package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareType;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.model.ItCategory;

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
public interface AwareTypeMapper extends BaseMapper<AwareType> {
    AwareType findById(Integer id);

    List<AwareType> findList();

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
