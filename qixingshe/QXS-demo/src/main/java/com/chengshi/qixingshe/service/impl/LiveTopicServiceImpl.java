package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.LiveTopic;
import com.chengshi.qixingshe.dao.LiveTopicMapper;
import com.chengshi.qixingshe.service.ILiveTopicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class LiveTopicServiceImpl extends ServiceImpl<LiveTopicMapper, LiveTopic> implements ILiveTopicService {
    @Autowired
    LiveTopicMapper liveTopicMapper;
    @Override
    public LiveTopic findLiveTopicById(Integer id) {
        return liveTopicMapper.findById(id);
    }

    @Override
    public List<LiveTopic> findLiveTopicList() {
        return liveTopicMapper.findList();
    }

    @Override
    public Page findLiveTopicPages(Query<Object> page, EntityWrapper<LiveTopic> wrapper) {
        page.setSize(10);
        page.setRecords(liveTopicMapper.findPage(page,page.getCondition()));
        return page;
    }

    @Override
    public Boolean deleteLiveTopic(Integer id) {
        LiveTopic liveTopic=new LiveTopic();
        liveTopic.setId(id);
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(liveTopic);
        int count=liveTopicMapper.delete(wrapper);
        if (count==1)
            return true;
        return false;
    }
}
