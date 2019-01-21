package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareTags;
import com.chengshi.qixingshe.dao.AwareTagsMapper;
import com.chengshi.qixingshe.service.IAwareTagsService;
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
public class AwareTagsServiceImpl extends ServiceImpl<AwareTagsMapper, AwareTags> implements IAwareTagsService {
    @Autowired
    AwareTagsMapper awareTagsMapper;
    @Override
    public AwareTags findAwareTagsById(Integer id) {
        return awareTagsMapper.findById(id);
    }

    @Override
    public List<AwareTags> findAwareTagsList() {
        return awareTagsMapper.findList();
    }

    @Override
    public Page findAwareTagsPages(Query<Object> page, EntityWrapper<AwareTags> wrapper) {
        page.setSize(10);
        page.setRecords(awareTagsMapper.findPage(page,page.getCondition()));
        return page;
    }

    @Override
    public Boolean deleteAwareTags(Integer id) {
        EntityWrapper wrapper=new EntityWrapper();
        AwareTags awareTags=new AwareTags();
        awareTags.setId(id);
        wrapper.setEntity(awareTags);
        int count=awareTagsMapper.delete(wrapper);
        if (count==1)
            return true;
        return false;
    }
}
