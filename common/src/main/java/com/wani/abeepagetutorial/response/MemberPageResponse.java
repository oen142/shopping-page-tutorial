package com.wani.abeepagetutorial.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberPageResponse {


    private PageResponse page;
    private List<MemberResponse> members;

    @Builder
    public MemberPageResponse(PageResponse page, List<MemberResponse> members) {
        this.page = page;
        this.members = members;
    }
}
