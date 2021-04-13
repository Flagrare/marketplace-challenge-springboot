package com.example.marketplace.repository

import com.example.marketplace.entity.Event
import org.springframework.data.mongodb.repository.MongoRepository

interface EventRepository : MongoRepository<Event, String>