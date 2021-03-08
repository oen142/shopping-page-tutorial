package com.wani.abeepagetutorial.domain.board.repository;

import com.wani.abeepagetutorial.domain.board.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article , Long> {

}
