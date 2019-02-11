package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.News;
import org.apache.ibatis.annotations.Param;

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
public interface NewsMapper extends BaseMapper<News> {
    News findById(Integer id);

    List<News> findList();

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);

    Integer batchChangeStatus(@Param("ids") List<Integer> ids, @Param("status") String status);
}
