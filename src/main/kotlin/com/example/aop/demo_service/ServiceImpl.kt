package com.example.aop.demo_service

import com.core.api.Service

class ServiceImpl(
    val repo: MockRepo
) : Service {
    override fun processRequest(request: String) {
        repo.processData(request)
    }
}