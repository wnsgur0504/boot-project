package com.bbp.bootboardproject.repository;

import com.bbp.bootboardproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
