package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestNafathGetStatus(
    val nationalId: String,
    val transId: String,
    val random: String
)

data class ResponseNafathGetStatus(
    val status: String
)

@RestController
class ControllerNafathGetStatus {
    @PostMapping("/naftahgetstatus")
    fun handleRequest(@RequestBody request: RequestNafathGetStatus): ResponseNafathGetStatus {
        // You can add any processing logic here if needed

        // Return a mock response
        return ResponseNafathGetStatus(
            status = "WAITING"
        )
    }
}