package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Aware;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.It;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IAwareService extends IService<Aware> {
    Aware findAwareById(Integer id);

    List<Aware> findAwareList();

    Page findAwarePages(Query<Object> page, EntityWrapper<Aware> wrapper);

    public Boolean changeAwareStatus(Integer id, String status);

    public Boolean deleteAware(Integer id);
}
