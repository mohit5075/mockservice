package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Request Data Class
data class HyperPayStatusRequest(
    val checkoutid: String,
    val merchantid: String,
    val cardtype: String
)

// Response Data Classes
data class ResultDetails(
    val ConnectorTxID1: String,
    val clearingInstituteName: String
)

data class Issuer(
    val bank: String,
    val website: String
)

data class Card(
    val bin: String,
    val binCountry: String,
    val last4Digits: String,
    val holder: String,
    val expiryMonth: String,
    val expiryYear: String,
    val issuer: Issuer,
    val type: String,
    val level: String,
    val country: String,
    val maxPanLength: String,
    val binType: String,
    val regulatedFlag: String
)

data class Customer(
    val givenName: String,
    val surname: String,
    val email: String,
    val ip: String
)

data class Billing(
    val street1: String,
    val city: String,
    val state: String,
    val postcode: String,
    val country: String
)

data class CustomParameters(
    val SHOPPER_EndToEndIdentity: String,
    val CTPE_DESCRIPTOR_TEMPLATE: String?
)

data class Risk(
    val score: String
)

data class ResultHyperpayStatus(
    val code: String,
    val description: String
)

data class HyperPayStatusResponse(
    val id: String,
    val registrationId: String,
    val paymentType: String,
    val paymentBrand: String,
    val amount: String,
    val currency: String,
    val descriptor: String,
    val merchantTransactionId: String,
    val result: ResultHyperpayStatus,
    val resultDetails: ResultDetails,
    val card: Card,
    val customer: Customer,
    val billing: Billing,
    val customParameters: CustomParameters,
    val risk: Risk,
    val buildNumber: String,
    val timestamp: String,
    val ndc: String
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
