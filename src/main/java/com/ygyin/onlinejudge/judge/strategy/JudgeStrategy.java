package com.ygyin.onlinejudge.judge.strategy;

import com.ygyin.onlinejudge.judge.sandbox.model.TestInfo;

/**
 * 策略模式
 * 定义判题策略
 */
public interface JudgeStrategy {

    /**
     * 判题
     * @param context
     * @return
     */
    TestInfo doProblemJudge(Context context);
}
