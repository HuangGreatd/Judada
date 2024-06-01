package com.judada.springbootinit.scoring;

import com.judada.springbootinit.model.entity.App;
import com.judada.springbootinit.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
 * @author juzipi
 * @date 2024/6/1 14:20
 */
public interface ScoringStrategy {
    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}
