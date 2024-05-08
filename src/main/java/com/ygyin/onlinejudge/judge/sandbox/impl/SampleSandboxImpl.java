package com.ygyin.onlinejudge.judge.sandbox.impl;

import com.ygyin.onlinejudge.judge.sandbox.Sandbox;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeRequest;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeResponse;
import com.ygyin.onlinejudge.judge.sandbox.model.TestInfo;
import com.ygyin.onlinejudge.model.enums.ProblemSubmitStatusEnum;
import com.ygyin.onlinejudge.model.enums.TestInfoMsgEnum;

import java.util.List;

/**
 * 用于示例测试业务流程的代码沙箱
 */
public class SampleSandboxImpl implements Sandbox {
    @Override
    public RunCodeResponse runCode(RunCodeRequest runCodeRequest) {
        List<String> inputList = runCodeRequest.getInputList();
        // New response and all set
        RunCodeResponse runCodeResponse = new RunCodeResponse();
        runCodeResponse.setOutputList(inputList);
        runCodeResponse.setRunStatus(ProblemSubmitStatusEnum.SUCCEED.getValue());
        runCodeResponse.setRunMsg("Sample Sandbox 执行成功");

        TestInfo testInfo = new TestInfo();
        testInfo.setMsg(TestInfoMsgEnum.ACCEPTED.getValue());
        testInfo.setMemory(1000L);
        testInfo.setTime(1000L);

        runCodeResponse.setTestInfo(testInfo);

        return runCodeResponse;
    }
}
