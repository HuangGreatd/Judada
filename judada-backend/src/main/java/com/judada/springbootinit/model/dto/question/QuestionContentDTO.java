package com.judada.springbootinit.model.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author juzipi
 * @date 2024/5/19 20:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionContentDTO {

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目选项列表
     */
    private List<Option> options;

    /**
     * 题目选项
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option {
        private String result;
        private int score;
        private String value;
        private String key;
    }
}