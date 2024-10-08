package com.example.MockServiceApp.controller

import com.example.MockServiceApp.controller.utils.CallbackPayload
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
data class AuthorizeData(
    @JsonProperty("accessToken")
    val accessToken: String,
    @JsonProperty("tenant-id")
    val tenantId: String
)
data class RequestData(
    val Debug: String,
    val Refresh: Boolean,
    val UniqueIdentifier: String,
    val ApplicationDate: String,
    val EnquiryDate: String,
    val RefreshFlag: String,
    val ProductType: String,
    val ProductSubType: String,
    val MobileNumber: String,
    val Purpose: String,
    val Nationality: String,
    val Region: String,
    val FinzeyDelinquencylevel: String,
    val DateOfBirthGregorian: String,
    val DateOfBirthHijri: String,
    val Gender: String,
    val MaritalStatus: String,
    val ResidentialStatus: String,
    val ResidentialType: String,
    val EmployerType: String,
    val ExistingCustInsuffPerformance: String,
    val ApplicantDisclosedSalary: String,
    val ApplicantDisclosedDateOfJoining: String,
    val REDFSupportAmount: String,
    val ApplicantType: String,
    val IDType: String,
    val IDNumber: String,
    val IDExpiryDate: String,
    val FamilyName: String,
    val FirstName: String,
    val RequestedFinanceAmount: String,
    val RequestedTenure: String,
    val ExistingCustMaxDelinq: String,
    val ExistingCustFlag: String,
    val NumberOfDependants: String,
    val NoDependantsPublicSchool: String,
    val NoDependantsPrivateSchool: String,
    val BreadwinnerIndicator: String,
    val COLDEFoodBeverage: String,
    val COLDEHousing: String,
    val COLDEUtilities: String,
    val COLDEHealthcare: String,
    val COLDEInsurance: String,
    val COLDETransportation: String,
    val COLDECommunication: String,
    val COLDEEducation: String,
    val COLDEHouseHelp: String,
    val COLDEExpatsTax: String,
    val COLDEOtherExpenses: String,
    val COLDEHomeRemittances: String,
    val NoHouseHelp: String
)

data class SampleRequest(
    val OriginId: String,
    val UserName: String,
    val Token: String,
    val RequestType: String,
    val Data: RequestData
)
data class ResultOutputValue(
    @JsonProperty("ResultOutput")
    val ResultOutput: ResultOutput
)
data class ResultOutput(
    @JsonProperty("Name")
    val Name: String,
    @JsonProperty("Value")
    val Value: Any?
)

data class CallbackRequest(
    @JsonProperty("data")
    val data : Any,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("statusCode")
    val statusCode: Int
)

data class FinalDecisionResponse(
    val Status: String,
    val RequestType: String,
    val ExecuteDecisionSmartResult:ExecuteDecisionSmartResult
)

data class ExecuteDecisionSmartResult(
    @JsonProperty("DecisionLogId")
    val DecisionLogId: String,
    @JsonProperty("DateExecuted")
    val DateExecuted: String,
    @JsonProperty("UniqueIdentifier")
    val UniqueIdentifier: String,
    @JsonProperty("DecisionFlowExternalReference")
    val DecisionFlowExternalReference: String,
    @JsonProperty("DecisionFlowId")
    val DecisionFlowId: String,
    @JsonProperty("DecisionFlowVersionNo")
    val DecisionFlowVersionNo: String,
    @JsonProperty("DecisionSmartResults")
    val DecisionSmartResults: List<ResultOutputValue>
)

data class ExecuteDecisionSmartResponse(
    @JsonProperty("ExecuteDecisionSmartResult")
    val ExecuteDecisionSmartResult: ExecuteDecisionSmartResult
)

data class Results(
    @JsonProperty("ExecuteDecisionSmartResponse")
    val ExecuteDecisionSmartResponse: ExecuteDecisionSmartResponse,
    @JsonProperty("BureauResult")
    val BureauResult: Any?
)

data class ResponseData(
    @JsonProperty("Results")
    val Results: Results
)

data class SampleResponse(
    @JsonProperty("status")
    val status: String,
    @JsonProperty("requestType")
    val requestType: String,
    @JsonProperty("commandType")
    val commandType: String,
    @JsonProperty("responseData")
    val responseData: ResponseData,
    @JsonProperty("errormessage")
    val errormessage: Any?
)

@RestController
class MockController {

    private val logger = LoggerFactory.getLogger(CallbackPayload::class.java)
    private val objectMapper = ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)

    @PostMapping("/qarar")
    fun processRequest(@RequestBody request: SampleRequest): SampleResponse {
        val response = SampleResponse(
            status = "Success",
            requestType = "Finzey",
            commandType = "FinalDecision",
            responseData = ResponseData(
                Results(
                    ExecuteDecisionSmartResponse(
                        ExecuteDecisionSmartResult(
                            DecisionLogId = "99a93bb0-0c9a-4e0f-b2ea-9382b1bc72bf",
                            DateExecuted = "2024-08-05T14:00:41.023522+03:00",
                            UniqueIdentifier = "qarar-1722855633",
                            DecisionFlowExternalReference = "ThirdFinzeyDecision",
                            DecisionFlowId = "3",
                            DecisionFlowVersionNo = "11",
                            DecisionSmartResults = listOf(
                                ResultOutputValue(ResultOutput("Score", "215.0000000000")),
                                ResultOutputValue(ResultOutput("BureauScore", "661")),
                                ResultOutputValue(ResultOutput("KnockOutStageDecision", "")),
                                ResultOutputValue(ResultOutput("KnockOutStageRejectReason", "")),
                                ResultOutputValue(ResultOutput("PostBureauStageDecision", "")),
                                ResultOutputValue(ResultOutput("PostBureauStageRejectReason", "")),
                                ResultOutputValue(ResultOutput("FinalDecisionReason", null)),
                                ResultOutputValue(ResultOutput("FinalDecision", "Accept")),
                                ResultOutputValue(ResultOutput("COLMResFoodBeverage", "563.451845794325")),
                                ResultOutputValue(ResultOutput("COLMResHousing", "1108.62675")),
                                ResultOutputValue(ResultOutput("COLMResUtilities", "55.6516120857578")),
                                ResultOutputValue(ResultOutput("COLMResHealthcare", "0")),
                                ResultOutputValue(ResultOutput("COLMResTransportation", "0")),
                                ResultOutputValue(ResultOutput("COLMResCommunication", "0")),
                                ResultOutputValue(ResultOutput("COLMResEducation", "0")),
                                ResultOutputValue(ResultOutput("COLMResHouseHelp", "0")),
                                ResultOutputValue(ResultOutput("COLMResExpatsTax", "0")),
                                ResultOutputValue(ResultOutput("COLMResOtherExpenses", "44")),
                                ResultOutputValue(ResultOutput("TotalCreditCommitments", "4467.21")),
                                ResultOutputValue(ResultOutput("TotalNonCreditCommitments", "6011.451845794325")),
                                ResultOutputValue(ResultOutput("MaxInstAmt", "15151.165")),
                                ResultOutputValue(ResultOutput("MaxEligAmt", "17547.588154205674")),
                                ResultOutputValue(ResultOutput("RequestedTenure", "12")),
                                ResultOutputValue(ResultOutput("RequestedTenureEligAmt", "181813.98")),
                                ResultOutputValue(ResultOutput("TotalNetMonthlyIncome", "28026.25")),
                                ResultOutputValue(ResultOutput("LengthOfService", "456")),
                                ResultOutputValue(ResultOutput("AgeAtApplicationGregorianInYears", "22.35")),
                                ResultOutputValue(ResultOutput("TotalCreditCommitmentsNonMortFlag", "True")),
                                ResultOutputValue(ResultOutput("NoObligFlag", "False"))
                            )
                        )
                    ),
                    BureauResult = null
                )
            ),
            errormessage = null
        )
        return response
    }

    @PostMapping("/finaldecision")
    fun handleFinalDecision(@RequestBody request: SampleResponse): FinalDecisionResponse {
        return FinalDecisionResponse(
            Status = request.status,
            RequestType = request.requestType,
            ExecuteDecisionSmartResult = request.responseData.Results.ExecuteDecisionSmartResponse.ExecuteDecisionSmartResult
        )
    }

    @PostMapping("/callback")
    fun callback(@RequestBody data: CallbackPayload): CallbackPayload {
        // Convert the payload to pretty JSON
        val jsonData = objectMapper.writeValueAsString(data)

        // Log the pretty-printed JSON
        logger.info("Received callback data:\n$jsonData")

        return data
    }

}