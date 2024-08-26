package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Request Data Class
data class UnifonicSMSRequest(
    val AppSid: String,
    val SenderID: String,
    val Body: String,
    val Recipient: String,
    val responseType: String,
    val CorrelationID: String,
    val baseEncode: String,
    val MessageType: String,
    val statusCallback: String,
    val async: String
)

// Response Data Classes
data class UnifonicSMSResponseData(
    val MessageID: Long,
    val CorrelationID: String,
    val Status: String,
    val NumberOfUnits: Int,
    val Cost: Int,
    val Balance: Int,
    val Recipient: String,
    val TimeCreated: String,
    val CurrencyCode: String
)

data class UnifonicSMSResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String,
    val Status: String,
    val data: UnifonicSMSResponseData
)

// Controller for UnifonicSMS
@RestController
class ControllerUnifonicSMS {

    @PostMapping("/unifonicsms")
    fun handleRequest(@RequestBody request: UnifonicSMSRequest): UnifonicSMSResponse {
        return UnifonicSMSResponse(
            success = true,
            message = "",
            errorCode = "ER-00",
            Status = "",
            data = UnifonicSMSResponseData(
                MessageID = 41000005747391,
                CorrelationID = "28803",
                Status = "Queued",
                NumberOfUnits = 2,
                Cost = 0,
                Balance = 0,
                Recipient = "966555573757",
                TimeCreated = "2024-01-17 07:36:22.314",
                CurrencyCode = ""
            )
        )
    }
}
