package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.It;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.ItTags;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IItService extends IService<It> {
    It findItById(Integer id);

    List<It> findItList();

    Page findItPages(Query<Object> page, EntityWrapper<It> wrapper);

    public Boolean addIt(It it);

    public Boolean deleteIt(Integer id);

    public Boolean updateIt(It it);

    public Boolean batchDeleteIt(List<Integer> ids);

    public Boolean changeItStatus(Integer id,String status);
}
