package com.example.demo.repository

import com.example.demo.entity.Article
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<Article, Long> {
    fun findAllByOrderByAddedAtDesc() : Iterable<Article>
}