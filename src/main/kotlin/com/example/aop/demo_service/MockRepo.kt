package com.example.aop.demo_service

import jakarta.persistence.EntityManager
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(propagation = Propagation.REQUIRED)
class MockRepo(
    val entityManager: EntityManager,
) {
    fun processData(request: String) {
        entityManager.flush()
        println("Processed: $request")
    }
}