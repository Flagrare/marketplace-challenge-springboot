package com.example.marketplace.repository

import com.example.marketplace.entity.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>