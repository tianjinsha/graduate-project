package com.chengshi.qixingshe.service;

import com.chengshi.qixingshe.model.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-28
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> findMenuList();

    Menu findMenuByid(Integer id);

}
