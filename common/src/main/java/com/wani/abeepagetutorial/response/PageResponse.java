package com.wani.abeepagetutorial.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageResponse {

    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int page;
    private int size;

    @Builder
    public PageResponse(int totalPages, boolean isFirstPage, boolean isLastPage, int page, int size) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.page = page;
        this.size = size;
    }
}
