package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.AwareMapper;
import com.chengshi.qixingshe.model.Aware;
import com.chengshi.qixingshe.service.IAwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class AwareServiceImpl extends ServiceImpl<AwareMapper, Aware> implements IAwareService {
    @Autowired
    AwareMapper awareMapper;

    @Override
    public Aware findAwareById(Integer id) {
        return awareMapper.findById(id);
    }

    @Override
    public List<Aware> findAwareList() {
        return awareMapper.findList();
    }

    @Override
    public Page findAwarePages(Query<Object> page, EntityWrapper<Aware> wrapper) {
        page.setSize(10);
        page.setRecords(awareMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean changeAwareStatus(Integer id, String status) {
        Aware aware = new Aware();
        aware.setId(id);
        aware.setStatus(status);
        int count = awareMapper.updateById(aware);
        if (count == 1)
            return true;
        return false;

    }

    @Override
    public Boolean deleteAware(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        Aware aware = new Aware();
        aware.setId(id);
        wrapper.setEntity(aware);
        int count = awareMapper.delete(wrapper);
        if (count == 1)
            return true;
        return false;
    }
}
