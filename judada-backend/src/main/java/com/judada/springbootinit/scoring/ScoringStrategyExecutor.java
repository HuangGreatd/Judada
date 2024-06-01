package com.judada.springbootinit.scoring;

import com.judada.springbootinit.common.ErrorCode;
import com.judada.springbootinit.exception.BusinessException;
import com.judada.springbootinit.model.entity.App;
import com.judada.springbootinit.model.entity.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * 评分策略执行器
 *
 * @author juzipi
 * @date 2024/6/1 15:03
 */
@Service
public class ScoringStrategyExecutor {

    //策略列表
    @Resource
    private List<ScoringStrategy> scoringStrategyList;

    public UserAnswer doScore(List<String> choiceList, App app) throws Exception {
        Integer appType = app.getAppType();
        Integer appScoringStrategy = app.getScoringStrategy();

        if (appType == null || appScoringStrategy == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
        }

        //根据注解获取策略
        for (ScoringStrategy strategy : scoringStrategyList) {
            if (strategy.getClass().isAnnotationPresent(ScoringStrategyConfig.class)) {
                ScoringStrategyConfig scoringStrategy = strategy.getClass().getAnnotation(ScoringStrategyConfig.class);
                if (scoringStrategy.appType() == appType && scoringStrategy.scoringStrategy() == appScoringStrategy) {
                    return strategy.doScore(choiceList, app);
                }
            }

        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
    }

}
