package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.ItTagsMapper;
import com.chengshi.qixingshe.model.ItTags;
import com.chengshi.qixingshe.service.IItTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class ItTagsServiceImpl extends ServiceImpl<ItTagsMapper, ItTags> implements IItTagsService {

    @Autowired
    ItTagsMapper itTagsMapper;

    @Override
    public ItTags findItTagsById(Integer id) {
        return itTagsMapper.findById(id);
    }

    @Override
    public List<ItTags> findItTagsList() {
        return itTagsMapper.findList();
    }

    @Override
    public Page findItTagsPages(Query<Object> page, EntityWrapper<ItTags> wrapper) {
        page.setSize(10);
        page.setRecords(itTagsMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean addItTags(ItTags itTags) {
        itTags.setCreateTime(new Date());
        int count = itTagsMapper.insert(itTags);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateItTags(ItTags itTags) {
        int count = itTagsMapper.updateById(itTags);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteItTags(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        ItTags itTags = new ItTags();
        itTags.setId(id);
        wrapper.setEntity(itTags);
        int count = itTagsMapper.delete(wrapper);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDeleteItTags(List<Integer> ids) {
        int count = itTagsMapper.deleteBatchIds(ids);
        if (count == ids.size()) {
            return true;
        }
        return false;
    }
}
