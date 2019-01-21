package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareType;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.It;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IAwareTypeService extends IService<AwareType> {
    AwareType findAwareTypeById(Integer id);

    List<AwareType> findAwareTypeList();

    Page findAwareTypePages(Query<Object> page, EntityWrapper<AwareType> wrapper);

    public Boolean deleteAwareType(Integer id);
}
