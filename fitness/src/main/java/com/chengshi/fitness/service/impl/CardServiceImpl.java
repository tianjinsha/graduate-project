package com.chengshi.fitness.service.impl;

import com.chengshi.fitness.model.Card;
import com.chengshi.fitness.dao.CardMapper;
import com.chengshi.fitness.service.ICardService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员卡类型 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService {

}
