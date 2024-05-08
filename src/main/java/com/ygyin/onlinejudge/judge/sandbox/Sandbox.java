package com.ygyin.onlinejudge.judge.sandbox;

import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeRequest;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeResponse;

/**
 * 代码沙箱接口
 */
public interface Sandbox {
    // 定义接口
    // 项目只调用接口，不调用具体实现类，在使用其他代码沙箱的实现类时无需修改名称，便于拓展

    RunCodeResponse runCode(RunCodeRequest runCodeRequest);
}
