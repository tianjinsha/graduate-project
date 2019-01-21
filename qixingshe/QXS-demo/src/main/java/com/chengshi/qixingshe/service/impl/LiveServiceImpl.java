package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Live;
import com.chengshi.qixingshe.dao.LiveMapper;
import com.chengshi.qixingshe.service.ILiveService;
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
public class LiveServiceImpl extends ServiceImpl<LiveMapper, Live> implements ILiveService {
    @Autowired
    LiveMapper liveMapper;
    @Override
    public Live findLiveById(Integer id) {
        return liveMapper.findById(id);
    }

    @Override
    public List<Live> findLiveList() {
        return liveMapper.findList();
    }

    @Override
    public Page findLivePages(Query<Object> page, EntityWrapper<Live> wrapper) {
        page.setSize(10);
        page.setRecords(liveMapper.findPage(page,page.getCondition()));
        return page;
    }

    @Override
    public Boolean changeLiveStatus(Integer id, String status) {
        Live live=new Live();
        live.setId(id);
        live.setStatus(status);
        int count=liveMapper.updateById(live);
        if (count==1)
            return true;
        return false;
    }

    @Override
    public Boolean deleteLive(Integer id) {
        Live live=new Live();
        live.setId(id);
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(live);
        int count=liveMapper.delete(wrapper);
        if (count==1)
            return true;
        return false;
    }
}
