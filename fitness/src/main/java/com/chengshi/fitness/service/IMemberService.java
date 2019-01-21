package com.chengshi.fitness.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.util.Query;

/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface IMemberService extends IService<Member> {

    public Page findMemerPage(Query<Object> query, EntityWrapper<Member> wrapper);

    public Member findMemberById(Integer id);

    public  Boolean addMember(Member member);

    public Boolean deleteMember(Integer id);

    public Boolean updateMember(Member member);
}
