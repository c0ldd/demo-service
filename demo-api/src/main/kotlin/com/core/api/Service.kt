package com.core.api

import org.springframework.transaction.annotation.Transactional

@Transactional
interface Service {
    fun processRequest(request: String)
}