package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.AwareTags;
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
public interface IAwareTagsService extends IService<AwareTags> {
    AwareTags findAwareTagsById(Integer id);

    List<AwareTags> findAwareTagsList();

    Page findAwareTagsPages(Query<Object> page, EntityWrapper<AwareTags> wrapper);

    Boolean deleteAwareTags(Integer id);
}
