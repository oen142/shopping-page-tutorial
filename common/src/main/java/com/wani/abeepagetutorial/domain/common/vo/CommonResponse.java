package com.wani.abeepagetutorial.domain.common.vo;

import lombok.Getter;

@Getter
public enum CommonResponse {

    SUCCESS(1 , "성공"),
    FAIL(0 , "알 수 없는 에러가 발생했습니다."),
    AUTH_FAIL(-1 , "로그인 후 이용해 주세요.");

    private int code;
    private String msg;

    CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
