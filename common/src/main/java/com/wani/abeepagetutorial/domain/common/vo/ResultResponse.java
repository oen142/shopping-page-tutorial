package com.wani.abeepagetutorial.domain.common.vo;

import lombok.Getter;

@Getter
public class ResultResponse<T> extends CommonResult {

    private T result;


    public ResultResponse(boolean success, int code, String msg) {
        super(success, code, msg);
    }

    public ResultResponse(boolean success, int code, String msg, T result) {
        super(success, code, msg);
        this.result = result;
    }
}
