package com.example.demo.controllerTest

import com.example.demo.entity.Article
import com.example.demo.entity.UserDetails
import com.example.demo.repository.ArticleRepository
import com.example.demo.repository.UserRepository
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.awt.PageAttributes.MediaType

@WebMvcTest
class ControllerTests {

    @MockBean
    lateinit var userRepository: UserRepository

    @MockBean
    lateinit var articleRepository: ArticleRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

//    @Test
//    fun `List articles`() {
//        val johnDoe = UserDetails("johnDoe", "John", "Doe")
//        val lorem5Article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)
//        val ipsumArticle = Article("Ipsum", "Ipsum", "dolor sit amet", johnDoe)
//        every { articleRepository.findAllByOrderByAddedAtDesc()} returns listOf(lorem5Article, ipsumArticle)
//        mockMvc.get("/api/article/").andExpect {
//            status { isOk() }
//        }
//    }

}