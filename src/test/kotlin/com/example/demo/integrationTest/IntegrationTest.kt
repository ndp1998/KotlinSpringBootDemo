package com.example.demo.integrationTest

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assert(entity.statusCode == HttpStatus.OK)
        entity.body?.let { assert(it.contains("<h1>Blog</h1>")) }
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            println(">> Setup")
        }

        @AfterAll
        fun teardown() {
            println(">> Tear Down")
        }
    }


}