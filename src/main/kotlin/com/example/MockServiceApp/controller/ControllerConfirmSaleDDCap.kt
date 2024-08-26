package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestConfirmSaleDDCap(
    val tran_stage_code: String,
    val compApplId: String
)

data class ResponseConfirmSaleDDCap(
    val message: String
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