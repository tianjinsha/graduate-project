package com.chengshi.fitness.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.fitness.model.CardHistory;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.util.Query;

/**
 * <p>
 *  办卡记录 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface ICardHistoryService extends IService<CardHistory> {

    public Page findCardHistoryPage(Query<Object> query, EntityWrapper<CardHistory> wrapper);

    public Member findCardHistoryById(Integer id);

    public  Boolean addCardHistory(CardHistory cardHistory);

    public Boolean deleteCardHistory(Integer id);

    public Boolean updateCardHistory(CardHistory cardHistory);

}
