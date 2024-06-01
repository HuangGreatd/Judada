package com.judada.springbootinit.model.dto.useranswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建用户回答请求
 *
*
 */
@Data
public class UserAnswerAddRequest implements Serializable {

    /**
     * 标题
     */
    private Long appId;

    /**
     * 用户答案（JSON 数组）
     */
    private List<String> choices;

    private static final long serialVersionUID = 1L;
}