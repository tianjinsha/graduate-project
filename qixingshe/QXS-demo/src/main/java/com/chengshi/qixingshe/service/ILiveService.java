package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Live;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.LiveTopic;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface ILiveService extends IService<Live> {
    Live findLiveById(Integer id);

    List<Live> findLiveList();

    Page findLivePages(Query<Object> page, EntityWrapper<Live> wrapper);

    Boolean changeLiveStatus(Integer id, String status);

    Boolean deleteLive(Integer id);
}
