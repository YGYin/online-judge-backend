package com.ygyin.onlinejudge.judge.sandbox.impl;

import com.ygyin.onlinejudge.judge.sandbox.Sandbox;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeRequest;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeResponse;
import com.ygyin.onlinejudge.judge.sandbox.model.TestInfo;
import com.ygyin.onlinejudge.model.enums.ProblemSubmitStatusEnum;
import com.ygyin.onlinejudge.model.enums.TestInfoMsgEnum;

import java.util.List;

/**
 * 用于接入第三方现成的代码沙箱，调用现成的第三方代码沙箱
 */
public class ExternalSandboxImpl implements Sandbox {
    @Override
    public RunCodeResponse runCode(RunCodeRequest runCodeRequest) {
        List<String> inputList = runCodeRequest.getInputList();

        RunCodeResponse runCodeResponse = new RunCodeResponse();
        runCodeResponse.setOutputList(inputList);
        runCodeResponse.setRunStatus(ProblemSubmitStatusEnum.SUCCEED.getValue());
        runCodeResponse.setRunMsg("代码沙箱测试执行成功");

        TestInfo testInfo = new TestInfo();
        testInfo.setMsg(TestInfoMsgEnum.ACCEPTED.getText());
        testInfo.setMemory(1000L);
        testInfo.setTime(1000L);

        runCodeResponse.setTestInfo(testInfo);

        return runCodeResponse;
    }
}
