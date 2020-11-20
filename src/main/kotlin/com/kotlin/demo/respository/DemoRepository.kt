package com.kotlin.demo.respository

import com.kotlin.demo.entity.User
import org.springframework.data.repository.CrudRepository

interface DemoRepository:CrudRepository<User,Long> {
    fun findByUserId(userId:String): User
}