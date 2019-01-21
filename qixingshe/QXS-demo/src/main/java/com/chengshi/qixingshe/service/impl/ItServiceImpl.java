package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.It;
import com.chengshi.qixingshe.dao.ItMapper;
import com.chengshi.qixingshe.service.IItService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Slf4j
@Service
public class ItServiceImpl extends ServiceImpl<ItMapper, It> implements IItService {

    @Autowired
    ItMapper itMapper;
    @Override
    public It findItById(Integer id) {
        return itMapper.findById(id);
    }

    @Override
    public List<It> findItList() {
        return itMapper.findList();
    }

    @Override
    public Page findItPages(Query<Object> page, EntityWrapper<It> wrapper) {
        page.setSize(10);
        page.setRecords(itMapper.findPage(page,page.getCondition()));
        return page;
    }

    @Override
    public Boolean addIt(It it) {
        it.setCreateTime(new Date());
        it.setUserId(1);
        log.info(it.toString());
        int count=itMapper.insert(it);
        if (count==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteIt(Integer id) {
        EntityWrapper wrapper=new EntityWrapper();
        It it=new It();
        it.setId(id);
        wrapper.setEntity(it);
        int count=itMapper.delete(wrapper);
        if (count==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateIt(It it) {
        return null;
    }

    @Override
    public Boolean batchDeleteIt(List<Integer> ids) {
        int count=itMapper.deleteBatchIds(ids);
        if (count==ids.size()){
            return true;
        }
        return false;
    }

    @Override
    public Boolean changeItStatus(Integer id, String status) {
        It it=new It();
        it.setId(id);
        it.setStatus(status);
        int count=itMapper.updateById(it);
        if (count==1){
            return true;
        }
        return false;
    }
}
