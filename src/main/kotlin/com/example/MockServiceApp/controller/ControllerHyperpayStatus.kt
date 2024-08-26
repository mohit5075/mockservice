package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class HyperPayStatusRequest(
    @JsonProperty("checkoutid") val checkoutid: String,
    @JsonProperty("merchantid") val merchantid: String,
    @JsonProperty("cardtype") val cardtype: String
)

// Response Data Classes
data class ResultDetails(
    @JsonProperty("ConnectorTxID1") val ConnectorTxID1: String,
    @JsonProperty("clearingInstituteName") val clearingInstituteName: String
)

data class Issuer(
    @JsonProperty("bank") val bank: String,
    @JsonProperty("website") val website: String
)

data class Card(
    @JsonProperty("bin") val bin: String,
    @JsonProperty("binCountry") val binCountry: String,
    @JsonProperty("last4Digits") val last4Digits: String,
    @JsonProperty("holder") val holder: String,
    @JsonProperty("expiryMonth") val expiryMonth: String,
    @JsonProperty("expiryYear") val expiryYear: String,
    @JsonProperty("issuer") val issuer: Issuer,
    @JsonProperty("type") val type: String,
    @JsonProperty("level") val level: String,
    @JsonProperty("country") val country: String,
    @JsonProperty("maxPanLength") val maxPanLength: String,
    @JsonProperty("binType") val binType: String,
    @JsonProperty("regulatedFlag") val regulatedFlag: String
)

data class Customer(
    @JsonProperty("givenName") val givenName: String,
    @JsonProperty("surname") val surname: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("ip") val ip: String
)

data class Billing(
    @JsonProperty("street1") val street1: String,
    @JsonProperty("city") val city: String,
    @JsonProperty("state") val state: String,
    @JsonProperty("postcode") val postcode: String,
    @JsonProperty("country") val country: String
)

data class CustomParameters(
    @JsonProperty("SHOPPER_EndToEndIdentity") val SHOPPER_EndToEndIdentity: String,
    @JsonProperty("CTPE_DESCRIPTOR_TEMPLATE") val CTPE_DESCRIPTOR_TEMPLATE: String?
)

data class Risk(
    @JsonProperty("score") val score: String
)

data class ResultHyperpayStatus(
    @JsonProperty("code") val code: String,
    @JsonProperty("description") val description: String
)

data class HyperPayStatusResponse(
    @JsonProperty("id") val id: String,
    @JsonProperty("registrationId") val registrationId: String,
    @JsonProperty("paymentType") val paymentType: String,
    @JsonProperty("paymentBrand") val paymentBrand: String,
    @JsonProperty("amount") val amount: String,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("descriptor") val descriptor: String,
    @JsonProperty("merchantTransactionId") val merchantTransactionId: String,
    @JsonProperty("result") val result: ResultHyperpayStatus,
    @JsonProperty("resultDetails") val resultDetails: ResultDetails,
    @JsonProperty("card") val card: Card,
    @JsonProperty("customer") val customer: Customer,
    @JsonProperty("billing") val billing: Billing,
    @JsonProperty("customParameters") val customParameters: CustomParameters,
    @JsonProperty("risk") val risk: Risk,
    @JsonProperty("buildNumber") val buildNumber: String,
    @JsonProperty("timestamp") val timestamp: String,
    @JsonProperty("ndc") val ndc: String
)


@RestController
class ControllerHyperpayStatus {

    @PostMapping("/hyperpaystatus")
    fun handleRequest(@RequestBody request: HyperPayStatusRequest): HyperPayStatusResponse {
        return HyperPayStatusResponse(
            id = "8ac7a4a08e1c1078018e2c11c52b01b5",
            registrationId = "8ac7a4a08e1c1078018e2c11c3f701a3",
            paymentType = "DB",
            paymentBrand = "MADA",
            amount = "2.00",
            currency = "SAR",
            descriptor = "6285.8382.9364 Alpha Arabia Finance",
            merchantTransactionId = "313",
            result = ResultHyperpayStatus(
                code = "000.100.110",
                description = "Request successfully processed in Merchant in Integrator Test Mode"
            ),
            resultDetails = ResultDetails(
                ConnectorTxID1 = "8ac7a4a08e1c1078018e2c11c52b01b5",
                clearingInstituteName = "SAIB MPGS"
            ),
            card = Card(
                bin = "529741",
                binCountry = "SA",
                last4Digits = "2387",
                holder = "abc",
                expiryMonth = "10",
                expiryYear = "2026",
                issuer = Issuer(
                    bank = "RIYAD BANK",
                    website = "HTTP://WWW.RIYADBANK.COM"
                ),
                type = "DEBIT",
                level = "STANDARD",
                country = "SA",
                maxPanLength = "16",
                binType = "PERSONAL",
                regulatedFlag = "N"
            ),
            customer = Customer(
                givenName = "SULTAN SHWAIT W ALOTAIBI",
                surname = "W",
                email = "test@gmail.com",
                ip = "2401:4900:1c2d:4d9a:a8be:ef43:ed1a:1e1d"
            ),
            billing = Billing(
                street1 = "6233 , 2796 , RIYADH , Al Saadah Dist. , 14257",
                city = "Riyadh",
                state = "RIYADH",
                postcode = "14257",
                country = "SA"
            ),
            customParameters = CustomParameters(
                SHOPPER_EndToEndIdentity = "6227e2e2f7204965f41ce4bfedd3ba49b5b14cbe230c4d9761f6204d2b7acecc",
                CTPE_DESCRIPTOR_TEMPLATE = ""
            ),
            risk = Risk(
                score = "0"
            ),
            buildNumber = "4cf0da2a0da510e18c9a3ee629818eeb6bd84fff@2024-03-07 15:31:01 +0000",
            timestamp = "2024-03-11 05:52:28+0000",
            ndc = "2BEA35F48B860B251181A6ECC7FF7A38.uat01-vm-tx02"
        )
    }
}
