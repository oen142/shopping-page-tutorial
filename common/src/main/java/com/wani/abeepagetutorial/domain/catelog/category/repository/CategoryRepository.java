package com.wani.abeepagetutorial.domain.catelog.category.repository;


import com.wani.abeepagetutorial.domain.catelog.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
