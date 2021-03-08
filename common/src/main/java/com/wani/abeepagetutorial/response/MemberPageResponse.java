package com.wani.abeepagetutorial.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberPageResponse {

    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int page;
    private int size;
    private List<MemberResponse> members;

    @Builder
    public MemberPageResponse(int totalPages, boolean isFirstPage, boolean isLastPage, int page, int size, List<MemberResponse> members) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.page = page;
        this.size = size;
        this.members = members;
    }
}
