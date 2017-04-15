package com.deccanherald.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deccanherald.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, UUID> {

}
