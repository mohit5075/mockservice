package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

data class ResultOutput(
    val Name: String,
    val Value: Any?
)

data class ExecuteDecisionSmartResult(
    val DecisionLogId: String,
    val DateExecuted: String,
    val UniqueIdentifier: String,
    val DecisionFlowExternalReference: String,
    val DecisionFlowId: String,
    val DecisionFlowVersionNo: String,
    val DecisionSmartResults: List<ResultOutput>
)

data class ExecuteDecisionSmartResponse(
    val ExecuteDecisionSmartResult: ExecuteDecisionSmartResult
)

data class Results(
    val ExecuteDecisionSmartResponse: ExecuteDecisionSmartResponse,
    val BureauResult: Any?
)

data class ResponseData(
    val Results: Results
)

data class SampleResponse(
    val status: String,
    val requestType: String,
    val commandType: String,
    val responseData: ResponseData,
    val errormessage: Any?
)

@RestController
@RequestMapping("/mock")
class MockController {
    @PostMapping("/process")
    fun processRequest(@RequestBody request: SampleRequest): SampleResponse {
        return SampleResponse(
            status = "Success "+request.UserName,
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
                                ResultOutput("Score", "215.0000000000"),
                                ResultOutput("BureauScore", "661"),
                                ResultOutput("KnockOutStageDecision", ""),
                                ResultOutput("KnockOutStageRejectReason", ""),
                                ResultOutput("PostBureauStageDecision", ""),
                                ResultOutput("PostBureauStageRejectReason", ""),
                                ResultOutput("FinalDecisionReason", null),
                                ResultOutput("FinalDecision", "Accept"),
                                ResultOutput("COLMResFoodBeverage", "563.451845794325"),
                                ResultOutput("COLMResHousing", "1108.62675"),
                                ResultOutput("COLMResUtilities", "55.6516120857578"),
                                ResultOutput("COLMResHealthcare", "0"),
                                ResultOutput("COLMResTransportation", "0"),
                                ResultOutput("COLMResCommunication", "0"),
                                ResultOutput("COLMResEducation", "0"),
                                ResultOutput("COLMResHouseHelp", "0"),
                                ResultOutput("COLMResExpatsTax", "0"),
                                ResultOutput("COLMResOtherExpenses", "44"),
                                ResultOutput("TotalCreditCommitments", "4467.21"),
                                ResultOutput("TotalNonCreditCommitments", "6011.451845794325"),
                                ResultOutput("MaxInstAmt", "15151.165"),
                                ResultOutput("MaxEligAmt", "17547.588154205674"),
                                ResultOutput("RequestedTenure", "12"),
                                ResultOutput("RequestedTenureEligAmt", "181813.98"),
                                ResultOutput("TotalNetMonthlyIncome", "28026.25"),
                                ResultOutput("LengthOfService", "456"),
                                ResultOutput("AgeAtApplicationGregorianInYears", "22.35"),
                                ResultOutput("TotalCreditCommitmentsNonMortFlag", "True"),
                                ResultOutput("NoObligFlag", "False")
                            )
                        )
                    ),
                    BureauResult = null
                )
            ),
            errormessage = null
        )
    }
}