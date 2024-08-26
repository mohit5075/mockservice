package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Request Data Class
data class HyperPayCheckoutRequest(
    val street1: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val givenName: String,
    val surname: String,
    val compApplId: String,
    val cardtype: String,
    val merchantid: String,
    val paymentAmount: String,
    val loanid: String
)

// Response Data Class
data class HyperPayCheckoutResponse(
    val result: Result,
    val buildNumber: String,
    val timestamp: String,
    val ndc: String,
    val id: String,
    val loanid: Int,
    val compApplId: Int,
    val paymentAmount: Double,
    val merchantid: String,
    val cardtype: String
)


data class Result(
    val code: String,
    val description: String
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
