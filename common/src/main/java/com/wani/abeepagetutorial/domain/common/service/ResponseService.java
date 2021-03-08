package com.wani.abeepagetutorial.domain.common.service;

import com.wani.abeepagetutorial.domain.common.vo.CommonResponse;
import com.wani.abeepagetutorial.domain.common.vo.CommonResult;
import com.wani.abeepagetutorial.domain.common.vo.ResultResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public <T> ResultResponse getResultResponse(T result) {
        return new ResultResponse<>(true, CommonResponse.SUCCESS.getCode(), CommonResponse.SUCCESS.getMsg());
    }

    public CommonResult getCommonResult() {
        return new CommonResult(true, CommonResponse.SUCCESS.getCode(), CommonResponse.SUCCESS.getMsg());
    }

    public CommonResult getFailResult(CommonResponse response) {
        return new CommonResult(false, response.getCode(), response.getMsg());
    }

}
