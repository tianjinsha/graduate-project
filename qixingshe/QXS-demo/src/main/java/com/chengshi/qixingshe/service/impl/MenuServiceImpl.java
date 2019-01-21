package com.chengshi.qixingshe.service.impl;

import com.chengshi.qixingshe.model.Menu;
import com.chengshi.qixingshe.dao.MenuMapper;
import com.chengshi.qixingshe.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuList() {
        return menuMapper.findList();
    }

    @Override
    public Menu findMenuByid(Integer id) {
        return menuMapper.findById(id);
    }
}
