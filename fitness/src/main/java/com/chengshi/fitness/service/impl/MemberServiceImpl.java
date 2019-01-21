package com.chengshi.fitness.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.dao.MemberMapper;
import com.chengshi.fitness.service.IMemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.fitness.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    public Page findMemerPage(Query<Object> query, EntityWrapper<Member> wrapper) {
        query.setSize(10);
        query.setRecords(memberMapper.findPage(query,query.getCondition()));
        return query;
    }

    public Member findMemberById(Integer id) {
        Member member=new Member();
        member.setId(id);
        return memberMapper.selectOne(member);
    }

    public Boolean addMember(Member member) {
        int count =memberMapper.insert(member);
        if(count==1)
            return true;
        return false;
    }

    public Boolean deleteMember(Integer id) {
        EntityWrapper wrapper=new EntityWrapper();
        Member member=new Member();
        member.setId(id);
        wrapper.setEntity(member);
        int count =memberMapper.delete(wrapper);

        if(count==1)
            return true;
        return false;
    }

    public Boolean updateMember(Member member) {
        int count=memberMapper.updateById(member);
        if(count==1)
            return true;
        return false;
    }
}
