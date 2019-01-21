package com.chengshi.fitness.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.util.Query;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface MemberMapper extends BaseMapper<Member> {

    List<Object> findPage(Query<Object> query, Map<String, Object> condition);
}
