package com.chengshi.fitness.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chengshi.fitness.model.AgeStage;
import com.chengshi.fitness.dao.AgeStageMapper;
import com.chengshi.fitness.model.Member;
import com.chengshi.fitness.service.IAgeStageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 年龄阶段 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class AgeStageServiceImpl extends ServiceImpl<AgeStageMapper, AgeStage> implements IAgeStageService {
    @Autowired
    AgeStageMapper ageStageMapper;
    public List<AgeStage> findAgeStateList() {
        return ageStageMapper.selectList(new EntityWrapper<AgeStage>());
    }

    public AgeStage findAgeStageById(Integer id) {
        AgeStage ageStage=new AgeStage();
        ageStage.setId(id);
        return ageStageMapper.selectOne(ageStage);
    }

    public Boolean addAgeStage(AgeStage ageStage) {
        int count =ageStageMapper.insert(ageStage);
        if (count==1)
            return true;
        return false;
    }

    public Boolean deleteAgeStage(Integer id) {
        EntityWrapper wrapper=new EntityWrapper();
        AgeStage ageStage=new AgeStage();
        ageStage.setId(id);
        wrapper.setEntity(ageStage);
        int count =ageStageMapper.delete(wrapper);
        if (count==1)
            return true;
        return false;
    }

    public Boolean updateAgeStage(AgeStage ageStage) {
        int count=ageStageMapper.updateById(ageStage);
        if (count==1)
            return true;
        return false;
    }
}
