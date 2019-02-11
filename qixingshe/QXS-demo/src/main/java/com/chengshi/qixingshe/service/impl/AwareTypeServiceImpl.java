package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.AwareTypeMapper;
import com.chengshi.qixingshe.model.AwareType;
import com.chengshi.qixingshe.service.IAwareTypeService;
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
public class AwareTypeServiceImpl extends ServiceImpl<AwareTypeMapper, AwareType> implements IAwareTypeService {
    @Autowired
    AwareTypeMapper awareTypeMapper;

    @Override
    public AwareType findAwareTypeById(Integer id) {
        return awareTypeMapper.findById(id);
    }

    @Override
    public List<AwareType> findAwareTypeList() {
        return awareTypeMapper.findList();
    }

    @Override
    public Page findAwareTypePages(Query<Object> page, EntityWrapper<AwareType> wrapper) {
        page.setSize(10);
        page.setRecords(awareTypeMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean deleteAwareType(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        AwareType awareType = new AwareType();
        awareType.setId(id);
        wrapper.setEntity(awareType);
        int count = awareTypeMapper.delete(wrapper);
        if (count == 1)
            return true;
        return false;
    }
}
