package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class RequestNafathCreate(
    @JsonProperty("nationalId") val nationalId: String,
    @JsonProperty("service") val service: String
)

// Response Data Class
data class ResponseNafathCreate(
    @JsonProperty("status") val status: String?,
    @JsonProperty("timestamp") val timestamp: String?,
    @JsonProperty("message") val message: String?,
    @JsonProperty("code") val code: String?,
    @JsonProperty("reference") val reference: String?,
    @JsonProperty("transId") val transId: String,
    @JsonProperty("random") val random: String
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