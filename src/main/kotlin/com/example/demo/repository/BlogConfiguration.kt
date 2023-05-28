package com.example.demo.repository

import com.example.demo.entity.Article
import com.example.demo.entity.UserDetails
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitalizer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner{
        val johnDoe = userRepository.save(UserDetails("johnDoe", "John", "Doe"))
        articleRepository.save(Article(
            title = "Lorem",
            headline = "Lorem",
            content = "dolor sit amet",
            author = johnDoe
        ))

        articleRepository.save(Article(
            title = "Ipsum",
            headline = "Ipsum",
            content = "dolor sit amet",
            author = johnDoe
        ))
    }
}