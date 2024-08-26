package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

// Model classes
data class SimahRetailRequest(
    @JsonProperty("productType")
    val productType: Int,
    @JsonProperty("amount")
    val amount: Double,
    @JsonProperty("applicants")
    val applicants: List<Applicant>,
    @JsonProperty("accept")
    val accept: Boolean,
    @JsonProperty("responseType")
    val responseType: Int
)

data class Applicant(
    @JsonProperty("identityInfo") val identityInfo: IdentityInfo,
    @JsonProperty("demographicInfo") val demographicInfo: DemographicInfo,
    @JsonProperty("address") val address: Address,
    @JsonProperty("contact") val contact: Contact,
    @JsonProperty("occupation") val occupation: Occupation
)

data class IdentityInfo(
    @JsonProperty("idNumber")
    val idNumber: String,
    @JsonProperty("idType")
    val idType: String
)

data class DemographicInfo(
    @JsonProperty("applicantType") val applicantType: String,
    @JsonProperty("idExpiryDate") val idExpiryDate: String,
    @JsonProperty("isHijriIDExpiryDate") val isHijriIDExpiryDate: Boolean,
    @JsonProperty("nationality") val nationality: Int,
    @JsonProperty("maritalStatus") val maritalStatus: Int,
    @JsonProperty("dateOfBirth") val dateOfBirth: String,
    @JsonProperty("isHijriDateOfBirth") val isHijriDateOfBirth: Boolean,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("gender") val gender: Int,
    @JsonProperty("secondName") val secondName: String,
    @JsonProperty("thirdName") val thirdName: String,
    @JsonProperty("familyName") val familyName: String
)


data class Address(
    @JsonProperty("addressType")
    val addressType: Int,
    @JsonProperty("zipCode")
    val zipCode: Int,
    @JsonProperty("city")
    val city: Int,
    @JsonProperty("buildingNumber")
    val buildingNumber: Int,
    @JsonProperty("street")
    val street: String,
    @JsonProperty("district")
    val district: String,
    @JsonProperty("unitNumber")
    val unitNumber: String,
    @JsonProperty("additionalNumber")
    val additionalNumber: String
)

data class Contact(
    @JsonProperty("contactType") val contactType: String,
    @JsonProperty("areaCode") val areaCode: String,
    @JsonProperty("phoneNumber") val phoneNumber: String,
    @JsonProperty("extension") val extension: String,
    @JsonProperty("countryCode") val countryCode: Int
)

data class Occupation(
    @JsonProperty("occupation") val occupation: String,
    @JsonProperty("selfEmployment") val selfEmployment: Boolean,
    @JsonProperty("certificateRegNo") val certificateRegNo: String,
    @JsonProperty("businessType") val businessType: Int,
    @JsonProperty("employerType") val employerType: Int,
    @JsonProperty("employerName") val employerName: String,
    @JsonProperty("basicIncome") val basicIncome: Double,
    @JsonProperty("totalMonthlyIncome") val totalMonthlyIncome: Double,
    @JsonProperty("address") val address: Address
)
data class SimahRetailResponse(
    @JsonProperty("message")
    val message: String,

    @JsonProperty("isSuccess")
    val isSuccess: Boolean,

    @JsonProperty("data")
    val data: List<ReportData>
)

data class ReportData(
    @JsonProperty("reportDate")
    val reportDate: String,

    @JsonProperty("reportDetails")
    val reportDetails: ReportDetails,

    @JsonProperty("providedDemographicsInfo")
    val providedDemographicsInfo: DemographicsInfo,

    @JsonProperty("availableDemographicsInfo")
    val availableDemographicsInfo: DemographicsInfo,

    @JsonProperty("prevEnquiries")
    val prevEnquiries: List<PrevEnquiry>
)

data class ReportDetails(
    @JsonProperty("reportDate")
    val reportDate: String,

    @JsonProperty("enquiryType")
    val enquiryType: String,

    @JsonProperty("productType")
    val productType: String,

    @JsonProperty("enquiryNumber")
    val enquiryNumber: String,

    @JsonProperty("numberOfApplicants")
    val numberOfApplicants: String,

    @JsonProperty("accountType")
    val accountType: String,

    @JsonProperty("referenceNumber")
    val referenceNumber: String,

    @JsonProperty("amount")
    val amount: String,

    @JsonProperty("memberType")
    val memberType: MemberType,

    @JsonProperty("status")
    val status: Status
)

data class DemographicsInfo(
    @JsonProperty("demIDNumber")
    val demIDNumber: String,

    @JsonProperty("demIDType")
    val demIDType: IDType,

    @JsonProperty("demIDExpiryDate")
    val demIDExpiryDate: String,

    @JsonProperty("demApplicantType")
    val demApplicantType: ApplicantType,

    @JsonProperty("demCustomerName")
    val demCustomerName: String,

    @JsonProperty("demFamilyName")
    val demFamilyName: String,

    @JsonProperty("demFirstName")
    val demFirstName: String,

    @JsonProperty("demSecondName")
    val demSecondName: String,

    @JsonProperty("demThirdName")
    val demThirdName: String,

    @JsonProperty("demCustomerNameAr")
    val demCustomerNameAr: String,

    @JsonProperty("demFamilyNameAr")
    val demFamilyNameAr: String,

    @JsonProperty("demFirstNameAr")
    val demFirstNameAr: String,

    @JsonProperty("demSecondNameAr")
    val demSecondNameAr: String,

    @JsonProperty("demThirdNameAr")
    val demThirdNameAr: String,

    @JsonProperty("demDateOfBirth")
    val demDateOfBirth: String,

    @JsonProperty("demGender")
    val demGender: String,

    @JsonProperty("demMaritalStatus")
    val demMaritalStatus: MaritalStatus,

    @JsonProperty("demNationality")
    val demNationality: Nationality
)

data class IDType(
    @JsonProperty("typeID")
    val typeID: Int,

    @JsonProperty("typeNameEN")
    val typeNameEN: String,

    @JsonProperty("typeNameAR")
    val typeNameAR: String,

    @JsonProperty("idTypeCode")
    val idTypeCode: String
)

data class ApplicantType(
    @JsonProperty("applicantTypeID")
    val applicantTypeID: Int,

    @JsonProperty("applicantTypeCode")
    val applicantTypeCode: String,

    @JsonProperty("applicantTypeNameEN")
    val applicantTypeNameEN: String,

    @JsonProperty("applicantTypeNameAR")
    val applicantTypeNameAR: String
)

data class MaritalStatus(
    @JsonProperty("matrialStatusId")
    val matrialStatusId: Int,

    @JsonProperty("statusNameEN")
    val statusNameEN: String,

    @JsonProperty("statusNameAR")
    val statusNameAR: String,

    @JsonProperty("maritalStatusCode")
    val maritalStatusCode: String
)

data class Nationality(
    @JsonProperty("couid")
    val couid: Int,

    @JsonProperty("couNameEN")
    val couNameEN: String,

    @JsonProperty("couNameAR")
    val couNameAR: String,

    @JsonProperty("couCode")
    val couCode: String?
)

data class MemberType(
    @JsonProperty("id")
    val id: Int,

    @JsonProperty("code")
    val code: String,

    @JsonProperty("nameAr")
    val nameAr: String,

    @JsonProperty("name")
    val name: String
)

data class Status(
    @JsonProperty("id")
    val id: Int,

    @JsonProperty("code")
    val code: String,

    @JsonProperty("nameAr")
    val nameAr: String,

    @JsonProperty("name")
    val name: String
)

data class PrevEnquiry(
    @JsonProperty("prevEnqDate")
    val prevEnqDate: String,

    @JsonProperty("preEnqType")
    val preEnqType: EnquiryType,

    @JsonProperty("prevEnqEnquirer")
    val prevEnqEnquirer: Enquirer,

    @JsonProperty("prevEnqMemberRef")
    val prevEnqMemberRef: String,

    @JsonProperty("prevEnquirerName")
    val prevEnquirerName: String,

    @JsonProperty("prevEnquirerNameAr")
    val prevEnquirerNameAr: String,

    @JsonProperty("prevEnqProductTypeDesc")
    val prevEnqProductTypeDesc: ProductTypeDesc,

    @JsonProperty("prevEnqAmount")
    val prevEnqAmount: Double,

    @JsonProperty("otherReason")
    val otherReason: String?
)

data class EnquiryType(
    @JsonProperty("enqTypeCode")
    val enqTypeCode: String,

    @JsonProperty("enqTypeDescriptionAr")
    val enqTypeDescriptionAr: String,

    @JsonProperty("enqTypeDescriptionEn")
    val enqTypeDescriptionEn: String
)

data class Enquirer(
    @JsonProperty("memberCode")
    val memberCode: String?,

    @JsonProperty("memberNameEN")
    val memberNameEN: String,

    @JsonProperty("memberNameAR")
    val memberNameAR: String
)

data class ProductTypeDesc(
    @JsonProperty("productId")
    val productId: Int,

    @JsonProperty("code")
    val code: String,

    @JsonProperty("textEn")
    val textEn: String,

    @JsonProperty("textAr")
    val textAr: String
)


@RestController
class ControllerSimahRetail {

    @PostMapping("/simahretail")
    fun handleRequest(@RequestBody request: SimahRetailRequest): SimahRetailResponse {
        return SimahRetailResponse(
            message = "",
            isSuccess = true,
            data = listOf(
                ReportData(
                    reportDate = "19/10/2023",
                    reportDetails = ReportDetails(
                        reportDate = "19/10/2023",
                        enquiryType = "New Application",
                        productType = "Personal Loan",
                        enquiryNumber = "271646622",
                        numberOfApplicants = "1",
                        accountType = "Single",
                        referenceNumber = "200667EQ19102316084884",
                        amount = "20000.00",
                        memberType = MemberType(
                            id = 1,
                            code = "FULL",
                            nameAr = "عضوية كامـلة ",
                            name = "Full"
                        ),
                        status = Status(
                            id = 1,
                            code = "ACTIV",
                            nameAr = "فعال",
                            name = "Active"
                        )
                    ),
                    providedDemographicsInfo = DemographicsInfo(
                        demIDNumber = "1083225589",
                        demIDType = IDType(
                            typeID = 1,
                            typeNameEN = "National ID",
                            typeNameAR = "هوية وطنية",
                            idTypeCode = "T"
                        ),
                        demIDExpiryDate = "31/10/2023",
                        demApplicantType = ApplicantType(
                            applicantTypeID = -1,
                            applicantTypeCode = "P",
                            applicantTypeNameEN = "Pimary",
                            applicantTypeNameAR = "Primary"
                        ),
                        demCustomerName = "Test Test Test Test",
                        demFamilyName = "Test",
                        demFirstName = "Test",
                        demSecondName = "Test",
                        demThirdName = "Test",
                        demCustomerNameAr = "فحص فحص فحص فحص",
                        demFamilyNameAr = "فحص",
                        demFirstNameAr = "فحص",
                        demSecondNameAr = "فحص",
                        demThirdNameAr = "فحص",
                        demDateOfBirth = "09/09/1990",
                        demGender = "Male",
                        demMaritalStatus = MaritalStatus(
                            matrialStatusId = 2,
                            statusNameEN = "Married",
                            statusNameAR = "متزوج / ـة",
                            maritalStatusCode = "M"
                        ),
                        demNationality = Nationality(
                            couid = 0,
                            couNameEN = "UNK",
                            couNameAR = "UNK",
                            couCode = null
                        )
                    ),
                    availableDemographicsInfo = DemographicsInfo(
                        demIDNumber = "1083225589",
                        demIDType = IDType(
                            typeID = 1,
                            typeNameEN = "National ID",
                            typeNameAR = "هوية وطنية",
                            idTypeCode = "T"
                        ),
                        demIDExpiryDate = "31/10/2023",
                        demApplicantType = ApplicantType(
                            applicantTypeID = -1,
                            applicantTypeCode = "P",
                            applicantTypeNameEN = "Pimary",
                            applicantTypeNameAR = "Primary"
                        ),
                        demCustomerName = "Test Test Test Test",
                        demFamilyName = "Test",
                        demFirstName = "Test",
                        demSecondName = "Test",
                        demThirdName = "Test",
                        demCustomerNameAr = "فحص فحص فحص فحص",
                        demFamilyNameAr = "فحص",
                        demFirstNameAr = "فحص",
                        demSecondNameAr = "فحص",
                        demThirdNameAr = "فحص",
                        demDateOfBirth = "09/09/1990",
                        demGender = "Male",
                        demMaritalStatus = MaritalStatus(
                            matrialStatusId = 2,
                            statusNameEN = "Married",
                            statusNameAR = "متزوج / ـة",
                            maritalStatusCode = "M"
                        ),
                        demNationality = Nationality(
                            couid = 0,
                            couNameEN = "UNK",
                            couNameAR = "UNK",
                            couCode = null
                        )
                    ),
                    prevEnquiries = listOf(
                        PrevEnquiry(
                            prevEnqDate = "19/10/2023",
                            preEnqType = EnquiryType(
                                enqTypeCode = "NA",
                                enqTypeDescriptionAr = " طلب جديد",
                                enqTypeDescriptionEn = "New Application"
                            ),
                            prevEnqEnquirer = Enquirer(
                                memberCode = null,
                                memberNameEN = "TBST",
                                memberNameAR = "TBST"
                            ),
                            prevEnqMemberRef = "200667EQ19102309425169",
                            prevEnquirerName = "Test,Test,Test,Test",
                            prevEnquirerNameAr = "فحص,فحص,فحص,فحص",
                            prevEnqProductTypeDesc = ProductTypeDesc(
                                productId = 23,
                                code = "PLN",
                                textEn = "Personal Loan",
                                textAr = "قرض شخصي"
                            ),
                            prevEnqAmount = 20000.0,
                            otherReason = null
                        ),
                        // Add other previous enquiries here...
                    )
                )
            )
        )
    }
}

