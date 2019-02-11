package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.model.Menu;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-28
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findList();

    Menu findById(Integer id);
}
