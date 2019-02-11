package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ItTags;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.News;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IItTagsService extends IService<ItTags> {
    ItTags findItTagsById(Integer id);

    List<ItTags> findItTagsList();

    Page findItTagsPages(Query<Object> page, EntityWrapper<ItTags> wrapper);

    Boolean addItTags(ItTags itTags);

    Boolean updateItTags(ItTags itTags);

    Boolean deleteItTags(Integer id);

    Boolean batchDeleteItTags(List<Integer> ids);

}
