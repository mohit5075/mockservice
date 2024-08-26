package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestNafathCreate(
    val nationalId: String,
    val service: String
)

data class ResponseNafathCreate(
    val status: String?,
    val timestamp: String?,
    val message: String?,
    val code: String?,
    val reference: String?,
    val transId: String,
    val random: String
)
@RestController
class ControllerNafathCreate {
    @PostMapping("/naftahcreate")
    fun handleRequest(@RequestBody request: RequestNafathCreate): ResponseNafathCreate {
        // You can add any processing logic here if needed

        // Return a mock response
        return ResponseNafathCreate(
            status = null,
            timestamp = null,
            message = null,
            code = null,
            reference = null,
            transId = "a64d0c08-0fa4-4218-99be-b6ce897ae00c",
            random = "74"
        )
    }
}