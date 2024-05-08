package com.ygyin.onlinejudge.judge.strategy;

import com.ygyin.onlinejudge.model.dto.problem.TestCase;
import com.ygyin.onlinejudge.judge.sandbox.model.TestInfo;
import com.ygyin.onlinejudge.model.entity.Problem;
import com.ygyin.onlinejudge.model.entity.ProblemSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文，定义在策略中传递的参数
 */

@Data
public class Context {

    private TestInfo testInfo;
    private Problem problem;

    private List<String> inputList;
    private List<String> outputList;
    private List<TestCase> testCaseList;
    private ProblemSubmit problemSubmit;

}
