package com.chengshi.fitness.service;

import com.baomidou.mybatisplus.service.IService;
import com.chengshi.fitness.dao.AgeStageMapper;
import com.chengshi.fitness.model.AgeStage;
import com.chengshi.fitness.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 年龄阶段 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface IAgeStageService extends IService<AgeStage> {

    List<AgeStage> findAgeStateList();

    public AgeStage findAgeStageById(Integer id);

    public  Boolean addAgeStage(AgeStage sgeStage);

    public Boolean deleteAgeStage(Integer id);

    public Boolean updateAgeStage(AgeStage ageStage);

}
