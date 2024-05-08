package com.ygyin.onlinejudge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ygyin.onlinejudge.annotation.AuthCheck;
import com.ygyin.onlinejudge.common.BaseResponse;
import com.ygyin.onlinejudge.common.ErrorCode;
import com.ygyin.onlinejudge.common.ResultUtils;
import com.ygyin.onlinejudge.constant.UserConstant;
import com.ygyin.onlinejudge.exception.BusinessException;
import com.ygyin.onlinejudge.model.dto.problem.ProblemQueryRequest;
import com.ygyin.onlinejudge.model.dto.problemsubmit.ProblemSubmitAddRequest;
import com.ygyin.onlinejudge.model.dto.problemsubmit.ProblemSubmitQueryRequest;
import com.ygyin.onlinejudge.model.entity.Problem;
import com.ygyin.onlinejudge.model.entity.ProblemSubmit;
import com.ygyin.onlinejudge.model.entity.User;
import com.ygyin.onlinejudge.model.vo.ProblemSubmitVO;
import com.ygyin.onlinejudge.service.ProblemSubmitService;
import com.ygyin.onlinejudge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
//@RequestMapping("/problem_submit")
@Slf4j
@Deprecated
public class ProblemSubmitController {

    @Resource
    private ProblemSubmitService problemSubmitService;

    @Resource
    private UserService userService;

//    /**
//     * 提交题目
//     *
//     * @param problemSubmitAddRequest 接收前端参数
//     * @param request
//     * @return 提交记录的 id
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doProblemSubmit(@RequestBody ProblemSubmitAddRequest problemSubmitAddRequest,
//                                              HttpServletRequest request) {
//        // 先判断请求参数不能为空，提交的题目 id 不能为空
//        if (problemSubmitAddRequest == null || problemSubmitAddRequest.getProblemId() <= 0)
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//
//        // 登录才能点赞
//        final User loginUser = userService.getLoginUser(request);
//        long problemSubmitId = problemSubmitService.doProblemSubmit(problemSubmitAddRequest, loginUser);
//        return ResultUtils.success(problemSubmitId);
//    }
//
//    /**
//     * 分页获取提交的题目列表（仅管理员可查看全部信息，普通用户仅能查看非答案即提交代码等公开信息）
//     *
//     * @param problemSubmitQueryRequest
//     * @return
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<ProblemSubmitVO>> listProblemSubmitByPage(@RequestBody ProblemSubmitQueryRequest problemSubmitQueryRequest, HttpServletRequest request) {
//        // 先从用户请求中获取查询条件，然后直接调用 ProblemSubmitService
//        long current = problemSubmitQueryRequest.getCurrent();
//        long size = problemSubmitQueryRequest.getPageSize();
//        // 调用的为 MyBatis Plus 所生成的分页方法，查出所有满足条件的原始的提交题目 page，
//        Page<ProblemSubmit> problemSubmitPage = problemSubmitService.page(new Page<>(current, size),
//                problemSubmitService.getQueryWrapper(problemSubmitQueryRequest));
//        // 提前用 request 获取当前 loginUser 供后面使用
//        final User loginUser = userService.getLoginUser(request);
//        // 进行脱敏，通过 request 获取当前登录用户判断对应权限，再返回脱敏后的 VO Page，
//        return ResultUtils.success(problemSubmitService.getProblemSubmitVOPage(problemSubmitPage, loginUser));
//    }

}
