package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.ItCategoryMapper;
import com.chengshi.qixingshe.model.ItCategory;
import com.chengshi.qixingshe.service.IItCategoryService;
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
public class ItCategoryServiceImpl extends ServiceImpl<ItCategoryMapper, ItCategory> implements IItCategoryService {
    @Autowired
    ItCategoryMapper itCategoryMapper;

    @Override
    public ItCategory findItCategoryById(Integer id) {
        return itCategoryMapper.findById(id);
    }

    @Override
    public List<ItCategory> findItCategoryList() {
        return itCategoryMapper.findList();
    }

    @Override
    public Page findItCategoryPages(Query<Object> page, EntityWrapper<ItCategory> wrapper) {
        page.setSize(10);
        page.setRecords(itCategoryMapper.findPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean addItCategory(ItCategory itCategory) {
        int count = itCategoryMapper.insert(itCategory);
        return null;
    }

    @Override
    public Boolean deleteItCategory(Integer id) {
        EntityWrapper wrapper = new EntityWrapper();
        ItCategory itCategory = new ItCategory();
        itCategory.setId(id);
        wrapper.setEntity(itCategory);
        int count = itCategoryMapper.delete(wrapper);
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDeleteItCategory(List<Integer> ids) {
        int count = itCategoryMapper.deleteBatchIds(ids);
        if (count == ids.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateItCategory(ItCategory itCategory) {
        int count = itCategoryMapper.updateById(itCategory);
        if (count == 1) {
            return true;
        }
        return false;
    }
}
