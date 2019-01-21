package com.chengshi.fitness.service.impl;

import com.chengshi.fitness.model.Discount;
import com.chengshi.fitness.dao.DiscountMapper;
import com.chengshi.fitness.service.IDiscountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员卡打折 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class DiscountServiceImpl extends ServiceImpl<DiscountMapper, Discount> implements IDiscountService {

}
