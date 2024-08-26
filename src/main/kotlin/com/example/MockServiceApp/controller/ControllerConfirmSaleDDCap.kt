package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestConfirmSaleDDCap(
    @JsonProperty("tran_stage_code") val tranStageCode: String,
    @JsonProperty("compApplId") val compApplId: String
)

data class ResponseConfirmSaleDDCap(
    @JsonProperty("message") val message: String
)

@RestController
class ControllerConfirmSaleDDCap {
    @PostMapping("/confirmSaleDDCap")
    fun handleRequest(@RequestBody request: RequestConfirmSaleDDCap): ResponseConfirmSaleDDCap {
        // Mock response with predefined values
        return ResponseConfirmSaleDDCap(
            message = "Deal ALPHA_2152512_000002 is complete."
        )
    }
}