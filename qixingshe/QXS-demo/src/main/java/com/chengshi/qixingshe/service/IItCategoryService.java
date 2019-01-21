package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.It;
import com.chengshi.qixingshe.model.ItCategory;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IItCategoryService extends IService<ItCategory> {

    ItCategory findItCategoryById(Integer id);

    List<ItCategory> findItCategoryList();

    Page findItCategoryPages(Query<Object> page, EntityWrapper<ItCategory> wrapper);

    public Boolean addItCategory(ItCategory itCategory);

    public Boolean deleteItCategory(Integer id);

    public Boolean batchDeleteItCategory(List<Integer> ids);

    public Boolean updateItCategory(ItCategory itCategory);
}
