package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class RequestTahaquq(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("mobileno")
    val mobileno: String
)

data class ResponseTahaquq(
    @JsonProperty("referenceNumber")
    val referenceNumber: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("mobile")
    val mobile: String,
    @JsonProperty("isOwner")
    val isOwner: Boolean
)

@RestController
class ControllerTahaquq {

    @PostMapping("/tahaquq")
    fun handleRequest(@RequestBody request: RequestTahaquq): ResponseTahaquq {

        // Return a mock response
        return ResponseTahaquq(
            referenceNumber = "263968d6-cf8f-40df-ac77-3254c4d67c7a",
            id = request.id,
            mobile = request.mobileno,
            isOwner = true
        )
    }
}