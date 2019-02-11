package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.dao.MessageMapper;
import com.chengshi.qixingshe.model.Message;
import com.chengshi.qixingshe.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
