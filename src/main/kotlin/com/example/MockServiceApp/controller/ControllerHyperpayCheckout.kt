package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class HyperPayCheckoutRequest(
    @JsonProperty("street1") val street1: String,
    @JsonProperty("city") val city: String,
    @JsonProperty("state") val state: String,
    @JsonProperty("country") val country: String,
    @JsonProperty("postcode") val postcode: String,
    @JsonProperty("givenName") val givenName: String,
    @JsonProperty("surname") val surname: String,
    @JsonProperty("compApplId") val compApplId: String,
    @JsonProperty("cardtype") val cardtype: String,
    @JsonProperty("merchantid") val merchantid: String,
    @JsonProperty("paymentAmount") val paymentAmount: String,
    @JsonProperty("loanid") val loanid: String
)

// Response Data Class
data class HyperPayCheckoutResponse(
    @JsonProperty("result") val result: Result,
    @JsonProperty("buildNumber") val buildNumber: String,
    @JsonProperty("timestamp") val timestamp: String,
    @JsonProperty("ndc") val ndc: String,
    @JsonProperty("id") val id: String,
    @JsonProperty("loanid") val loanid: Int,
    @JsonProperty("compApplId") val compApplId: Int,
    @JsonProperty("paymentAmount") val paymentAmount: Double,
    @JsonProperty("merchantid") val merchantid: String,
    @JsonProperty("cardtype") val cardtype: String
)

data class Result(
    @JsonProperty("code") val code: String,
    @JsonProperty("description") val description: String
)


@RestController
class ControllerHyperpayCheckout {

    @PostMapping("/hyperpaycheckout")
    fun handleRequest(@RequestBody request: HyperPayCheckoutRequest): HyperPayCheckoutResponse {
        return HyperPayCheckoutResponse(
            result = Result(
                code = "000.200.100",
                description = "successfully created checkout"
            ),
            buildNumber = "4cf0da2a0da510e18c9a3ee629818eeb6bd84fff@2024-03-07 15:31:01 +0000",
            timestamp = "2024-03-11 05:52:01+0000",
            ndc = "2BEA35F48B860B251181A6ECC7FF7A38.uat01-vm-tx02",
            id = "2BEA35F48B860B251181A6ECC7FF7A38.uat01-vm-tx02",
            loanid = request.loanid.toInt(),
            compApplId = request.compApplId.toInt(),
            paymentAmount = request.paymentAmount.toDouble(),
            merchantid = request.merchantid,
            cardtype = request.cardtype
        )
    }
}
