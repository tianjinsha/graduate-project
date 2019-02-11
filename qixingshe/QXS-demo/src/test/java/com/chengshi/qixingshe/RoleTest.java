package com.chengshi.qixingshe;

import com.chengshi.qixingshe.dao.ManagerMapper;
import com.chengshi.qixingshe.dao.RoleMapper;
import com.chengshi.qixingshe.model.Manager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {
    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    RoleMapper roleMapper;



    @Test
    public void manager() {
//        log.info("manager:" + managerMapper.findManagerById(1));
        log.info("manager:" + managerMapper.findManagerByAccount("86608"));
    }

    @Test
    public void role() {
        log.info("role:" + roleMapper.findRoleById(1));
    }

    @Test
    public void roleListTest() {
        Manager manager = managerMapper.findManagerByAccount("86608");
        List<String> collect = manager.getRoles().stream().map(c -> c.getIdentity()).collect(Collectors.toList());
        manager.getRoles().stream().map(c -> new SimpleGrantedAuthority(c.getDescription())).collect(Collectors.toList());
        collect.forEach(c -> System.out.println("role:" + c));
    }


    @Test
    public void  managerTest(){

    }
}
