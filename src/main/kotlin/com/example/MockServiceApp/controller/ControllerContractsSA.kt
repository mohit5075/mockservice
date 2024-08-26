package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class ContractsSARequest(
    @JsonProperty("contractName") val contractName: String,
    @JsonProperty("contractNumber") val contractNumber: String,
    @JsonProperty("contractBeneficiaries") val contractBeneficiaries: List<Beneficiary>,
    @JsonProperty("templateCode") val templateCode: String,
    @JsonProperty("templateData") val templateData: String,
    @JsonProperty("sanadGroupRequest") val sanadGroupRequest: SanadGroupRequest,
    @JsonProperty("waitingDays") val waitingDays: Int
)

data class Beneficiary(
    @JsonProperty("beneficiaryIdNumber") val beneficiaryIdNumber: String,
    @JsonProperty("beneficiaryName") val beneficiaryName: String,
    @JsonProperty("beneficiaryNameAr") val beneficiaryNameAr: String,
    @JsonProperty("beneficiaryMobileNumber") val beneficiaryMobileNumber: String,
    @JsonProperty("beneficiaryEmail") val beneficiaryEmail: String,
    @JsonProperty("beneficiaryRegionCode") val beneficiaryRegionCode: Int,
    @JsonProperty("responseTimeInMinutes") val responseTimeInMinutes: Int,
    @JsonProperty("lang") val lang: String,
    @JsonProperty("signatureLang") val signatureLang: String,
    @JsonProperty("shareApprovalURL") val shareApprovalURL: Boolean,
    @JsonProperty("isSignatureMethodFingerprint") val isSignatureMethodFingerprint: Boolean,
    @JsonProperty("isReadOnly") val isReadOnly: Boolean
)

data class SanadGroupRequest(
    @JsonProperty("debtor") val debtor: Debtor,
    @JsonProperty("debtor_phone_number") val debtorPhoneNumber: String,
    @JsonProperty("country_of_issuance") val countryOfIssuance: String,
    @JsonProperty("city_of_issuance") val cityOfIssuance: String,
    @JsonProperty("country_of_payment") val countryOfPayment: String,
    @JsonProperty("city_of_payment") val cityOfPayment: String,
    @JsonProperty("reference_id") val referenceId: String,
    @JsonProperty("total_value") val totalValue: String,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("sanad_type") val sanadType: String,
    @JsonProperty("max_approve_duration") val maxApproveDuration: Int,
    @JsonProperty("issued_at") val issuedAt: String,
    @JsonProperty("reason") val reason: String,
    @JsonProperty("sanad") val sanad: List<Sanad>
)

data class Debtor(
    @JsonProperty("national_id") val nationalId: String
)

data class Sanad(
    @JsonProperty("total_value") val totalValue: String,
    @JsonProperty("reference_id") val referenceId: String,
    @JsonProperty("due_type") val dueType: String,
    @JsonProperty("due_date") val dueDate: String
)

// Response Data Classes
data class ContractsSAResponseData(
    @JsonProperty("contractNumber") val contractNumber: String,
    @JsonProperty("contractStatusCode") val contractStatusCode: String,
    @JsonProperty("createdOn") val createdOn: String,
    @JsonProperty("fileSharingLink") val fileSharingLink: String,
    @JsonProperty("unSignFileLink") val unSignFileLink: String
)

data class ContractsSAResponse(
    @JsonProperty("data") val data: ContractsSAResponseData,
    @JsonProperty("messages") val messages: List<String>,
    @JsonProperty("statusCode") val statusCode: String?,
    @JsonProperty("httpCode") val httpCode: Int,
    @JsonProperty("succeeded") val succeeded: Boolean,
    @JsonProperty("allItemCount") val allItemCount: Int
)

// Controller for ContractsSA
@RestController
class ControllerContractsSA {

    @PostMapping("/contractssa")
    fun handleRequest(@RequestBody request: ContractsSARequest): ContractsSAResponse {
        return ContractsSAResponse(
            data = ContractsSAResponseData(
                contractNumber = "35738",
                contractStatusCode = "2",
                createdOn = "2023-12-03T18:59:15.8512306+03:00",
                fileSharingLink = "https://sandbox.contracts.sa/ApproveContract/en?code=eolIJoDpLe1cLwEZWtchSWcwXMzhpKT623lk41r7nFSGXel0QX6l1G589CfieiMK",
                unSignFileLink = "https://sandbox.contracts.sa/Display/en?code=eolIJoDpLe1cLwEZWtchSWcwXMzhpKT623lk41r7nFSGXel0QX6l1G589CfieiMK"
            ),
            messages = emptyList(),
            statusCode = null,
            httpCode = 0,
            succeeded = true,
            allItemCount = 0
        )
    }
}
