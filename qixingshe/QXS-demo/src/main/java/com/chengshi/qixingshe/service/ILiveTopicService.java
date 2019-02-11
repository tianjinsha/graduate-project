package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.LiveTopic;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface ILiveTopicService extends IService<LiveTopic> {
    LiveTopic findLiveTopicById(Integer id);

    List<LiveTopic> findLiveTopicList();

    Page findLiveTopicPages(Query<Object> page, EntityWrapper<LiveTopic> wrapper);

    Boolean deleteLiveTopic(Integer id);
}
