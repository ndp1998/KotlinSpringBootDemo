package com.example.demo.repositoryTest

import com.example.demo.entity.Article
import com.example.demo.entity.UserDetails
import com.example.demo.repository.ArticleRepository
import com.example.demo.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoryTest @Autowired constructor(
    val entityManager : TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
)  {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val johnDoe = UserDetails("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        val article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        if (found != null) {
            assert(found == article)
        }
    }

    @Test
    fun `When findByLogin then return User`() {
        val johnDoe = UserDetails("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val user = userRepository.findByLogin(johnDoe.login)
        if (user != null) {
            assert(user == johnDoe)
        }
    }
}
