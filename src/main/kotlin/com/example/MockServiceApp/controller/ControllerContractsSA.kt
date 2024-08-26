package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Request Data Class
data class ContractsSARequest(
    val contractName: String,
    val contractNumber: String,
    val contractBeneficiaries: List<Beneficiary>,
    val templateCode: String,
    val templateData: String,
    val sanadGroupRequest: SanadGroupRequest,
    val waitingDays: Int
)

data class Beneficiary(
    val beneficiaryIdNumber: String,
    val beneficiaryName: String,
    val beneficiaryNameAr: String,
    val beneficiaryMobileNumber: String,
    val beneficiaryEmail: String,
    val beneficiaryRegionCode: Int,
    val responseTimeInMinutes: Int,
    val lang: String,
    val signatureLang: String,
    val shareApprovalURL: Boolean,
    val isSignatureMethodFingerprint: Boolean,
    val isReadOnly: Boolean
)

data class SanadGroupRequest(
    val debtor: Debtor,
    val debtor_phone_number: String,
    val country_of_issuance: String,
    val city_of_issuance: String,
    val country_of_payment: String,
    val city_of_payment: String,
    val reference_id: String,
    val total_value: String,
    val currency: String,
    val sanad_type: String,
    val max_approve_duration: Int,
    val issued_at: String,
    val reason: String,
    val sanad: List<Sanad>
)

data class Debtor(
    val national_id: String
)

data class Sanad(
    val total_value: String,
    val reference_id: String,
    val due_type: String,
    val due_date: String
)

// Response Data Classes
data class ContractsSAResponseData(
    val contractNumber: String,
    val contractStatusCode: String,
    val createdOn: String,
    val fileSharingLink: String,
    val unSignFileLink: String
)

data class ContractsSAResponse(
    val data: ContractsSAResponseData,
    val messages: List<String>,
    val statusCode: String?,
    val httpCode: Int,
    val succeeded: Boolean,
    val allItemCount: Int
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
