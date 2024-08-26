package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class RequestNafathGetStatus(
    @JsonProperty("nationalId") val nationalId: String,
    @JsonProperty("transId") val transId: String,
    @JsonProperty("random") val random: String
)

// Response Data Class
data class ResponseNafathGetStatus(
    @JsonProperty("status") val status: String
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