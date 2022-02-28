package com.example.breakingbad.data.api

import com.example.breakingbad.domain.ApiRepository
import javax.inject.Inject

class ApiRepositoryImpl
    @Inject constructor(
        private val api:ApiRequests
    ) :ApiRepository {
        
}