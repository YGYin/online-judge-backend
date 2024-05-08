package com.ygyin.onlinejudge.judge.sandbox;

import com.ygyin.onlinejudge.judge.sandbox.impl.SampleSandboxImpl;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeRequest;
import com.ygyin.onlinejudge.judge.sandbox.model.RunCodeResponse;
import com.ygyin.onlinejudge.model.enums.ProblemLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class SandboxTest {

    // 在 Spring 的 bean 中通过 @Value 读取配置文件中 sandbox.type 参数
    @Value("${sandbox.type:sample}")
    private String type;

    @Test
    void runCode() {
        String code = "int main(){ }";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        String language = ProblemLanguageEnum.JAVA.getValue();
        // 基于 build，可以不需要通过 new，直接链式调用实现属性初始化并返回新对象
        RunCodeRequest runCodeRequest = RunCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();

        // 此处如果要更换测试的实现类，每次都要更改 new 后的实现类，相关引入全都需要更改
        // 通过工厂模式来提高通用性，根据用户传入的字符串作为参数，来生成对应的代码沙箱实现类
        Sandbox sandbox = new SampleSandboxImpl();
        RunCodeResponse runCodeResponse = sandbox.runCode(runCodeRequest);
        Assertions.assertNotNull(runCodeResponse);
    }

    @Test
    void runCodeByValueWithFactory() {
        String code = "int main(){ }";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        String language = ProblemLanguageEnum.JAVA.getValue();
        // 基于 build，可以不需要通过 new，直接链式调用实现属性初始化并返回新对象
        RunCodeRequest runCodeRequest = RunCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();

        // 此处如果要更换测试的实现类，每次都要更改 new 后的实现类，相关引入全都需要更改
        // 通过工厂模式来提高通用性，根据用户传入的字符串作为参数，来生成对应的代码沙箱实现类
        Sandbox sandbox = SandboxFactory.newInstance(type);
        RunCodeResponse runCodeResponse = sandbox.runCode(runCodeRequest);
        Assertions.assertNotNull(runCodeResponse);
    }

    @Test
    void runCodeByProxyWithFactory() {
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"Result: \" + (a + b));\n" +
                "    }\n" +
                "}";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        String language = ProblemLanguageEnum.JAVA.getValue();
        // 基于 build，可以不需要通过 new，直接链式调用实现属性初始化并返回新对象
        RunCodeRequest runCodeRequest = RunCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();

        Sandbox sandbox = SandboxFactory.newInstance(type);
        sandbox = new SandboxProxy(sandbox);
        RunCodeResponse runCodeResponse = sandbox.runCode(runCodeRequest);
        Assertions.assertNotNull(runCodeResponse);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String type = sc.next();
            Sandbox sandbox = SandboxFactory.newInstance(type);

            String code = "int main(){ }";
            List<String> inputList = Arrays.asList("1 2", "3 4");
            String language = ProblemLanguageEnum.JAVA.getValue();
            // 基于 build，可以不需要通过 new，直接链式调用实现属性初始化并返回新对象
            RunCodeRequest runCodeRequest = RunCodeRequest.builder()
                    .code(code)
                    .inputList(inputList)
                    .language(language)
                    .build();

            RunCodeResponse runCodeResponse = sandbox.runCode(runCodeRequest);
        }
    }
}