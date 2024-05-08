package com.ygyin.onlinejudge.model.dto.problem;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 更新请求
 *
 */
@Data
public class ProblemUpdateRequest implements Serializable {
    // Update 提供给管理员使用

    /**
     * 题目 id
     */
    private Long id;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题解
     */
    private String res;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 测试用例(json array)
     */
    private List<TestCase> testCase;

    /**
     * 判题配置(json object)
     */
    private TestConfig testConfig;

    private static final long serialVersionUID = 1L;
}