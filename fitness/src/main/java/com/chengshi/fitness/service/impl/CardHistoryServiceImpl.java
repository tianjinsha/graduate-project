package com.chengshi.fitness.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.fitness.model.CardHistory;
import com.chengshi.fitness.dao.CardHistoryMapper;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.service.ICardHistoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.fitness.util.Query;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  办卡记录 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class CardHistoryServiceImpl extends ServiceImpl<CardHistoryMapper, CardHistory> implements ICardHistoryService {

    @Autowired
    CardHistoryMapper cardHistoryMapper;
    public Page findCardHistoryPage(Query<Object> query, EntityWrapper<CardHistory> wrapper) {
        query.setSize(10);
        query.setRecords(cardHistoryMapper.findPage(query,query.getCondition()));
        return query;
    }

    public Member findCardHistoryById(Integer id) {
        CardHistory cardHistory=new CardHistory();
        cardHistory.setCardId(id);
        cardHistoryMapper.selectOne(cardHistory);
        return null;
    }

    public Boolean addCardHistory(CardHistory cardHistory) {
        cardHistory.setCreateTime(new Date(System.currentTimeMillis()));
        int count=cardHistoryMapper.insert(cardHistory);
        if (count==1)
            return true;
        return false;
    }

    public Boolean deleteCardHistory(Integer id) {
        return null;
    }

    public Boolean updateCardHistory(CardHistory cardHistory) {
        return null;
    }
}
