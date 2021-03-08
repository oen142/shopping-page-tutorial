package com.wani.abeepagetutorial.domain.common.vo;

import lombok.Getter;

@Getter
public class CommonResult {

    private final boolean success;
    private final int code;
    private final String msg;

    public CommonResult(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
