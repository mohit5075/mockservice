package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

// Request Data Class
data class UnifonicSMSRequest(
    @JsonProperty("AppSid")
    val AppSid: String,
    @JsonProperty("SenderID")
    val SenderID: String,
    @JsonProperty("Body")
    val Body: String,
    @JsonProperty("Recipient")
    val Recipient: String,
    @JsonProperty("responseType")
    val responseType: String,
    @JsonProperty("CorrelationID")
    val CorrelationID: String,
    @JsonProperty("baseEncode")
    val baseEncode: String,
    @JsonProperty("MessageType")
    val MessageType: String,
    @JsonProperty("statusCallback")
    val statusCallback: String,
    @JsonProperty("async")
    val async: String
)

// Response Data Classes
data class UnifonicSMSResponseData(
    @JsonProperty("MessageID")
    val MessageID: Long,

    @JsonProperty("CorrelationID")
    val CorrelationID: String,

    @JsonProperty("Status")
    val Status: String,

    @JsonProperty("NumberOfUnits")
    val NumberOfUnits: Int,

    @JsonProperty("Cost")
    val Cost: Int,

    @JsonProperty("Balance")
    val Balance: Int,

    @JsonProperty("Recipient")
    val Recipient: String,

    @JsonProperty("TimeCreated")
    val TimeCreated: String,

    @JsonProperty("CurrencyCode")
    val CurrencyCode: String
)

data class UnifonicSMSResponse(
    @JsonProperty("success")
    val success: Boolean,

    @JsonProperty("message")
    val message: String,

    @JsonProperty("errorCode")
    val errorCode: String,

    @JsonProperty("Status")
    val Status: String,

    @JsonProperty("data")
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
