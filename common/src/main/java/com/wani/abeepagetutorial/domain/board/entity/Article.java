package com.wani.abeepagetutorial.domain.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    private String title;

    @Embedded
    private ArticleContent content;

    @Builder
    private Article(String title, ArticleContent content) {
        this.title = title;
        this.content = content;
    }

    public static Article of(String title, ArticleContent content) {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }

}
