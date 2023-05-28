package com.example.demo.repository

import com.example.demo.entity.UserDetails
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserDetails, Long>{
    fun findByLogin(login: String): UserDetails?
}