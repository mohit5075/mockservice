package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Model classes
data class SimahRetailRequest(
    val productType: Int,
    val amount: Double,
    val applicants: List<Applicant>,
    val accept: Boolean,
    val responseType: Int
)

data class Applicant(
    val identityInfo: IdentityInfo,
    val demographicInfo: DemographicInfo,
    val address: Address,
    val contact: Contact,
    val occupation: Occupation
)

data class IdentityInfo(
    val idNumber: String,
    val idType: String
)

data class DemographicInfo(
    val applicantType: String,
    val idExpiryDate: String,
    val isHijriIDExpiryDate: Boolean,
    val nationality: Int,
    val maritalStatus: Int,
    val dateOfBirth: String,
    val isHijriDateOfBirth: Boolean,
    val firstName: String,
    val gender: Int,
    val secondName: String,
    val thirdName: String,
    val familyName: String
)

data class Address(
    val addressType: Int,
    val zipCode: Int,
    val city: Int,
    val buildingNumber: Int,
    val street: String,
    val district: String,
    val unitNumber: String,
    val additionalNumber: String
)

data class Contact(
    val contactType: String,
    val areaCode: String,
    val phoneNumber: String,
    val extension: String,
    val countryCode: Int
)

data class Occupation(
    val occupation: String,
    val selfEmployment: Boolean,
    val certificateRegNo: String,
    val businessType: Int,
    val employerType: Int,
    val employerName: String,
    val basicIncome: Double,
    val totalMonthlyIncome: Double,
    val address: Address
)

data class SimahRetailResponse(
    val message: String,
    val isSuccess: Boolean,
    val data: List<ReportData>
)

data class ReportData(
    val reportDate: String,
    val reportDetails: ReportDetails,
    val providedDemographicsInfo: DemographicsInfo,
    val availableDemographicsInfo: DemographicsInfo,
    val prevEnquiries: List<PrevEnquiry>
)

data class ReportDetails(
    val reportDate: String,
    val enquiryType: String,
    val productType: String,
    val enquiryNumber: String,
    val numberOfApplicants: String,
    val accountType: String,
    val referenceNumber: String,
    val amount: String,
    val memberType: MemberType,
    val status: Status
)

data class DemographicsInfo(
    val demIDNumber: String,
    val demIDType: IDType,
    val demIDExpiryDate: String,
    val demApplicantType: ApplicantType,
    val demCustomerName: String,
    val demFamilyName: String,
    val demFirstName: String,
    val demSecondName: String,
    val demThirdName: String,
    val demCustomerNameAr: String,
    val demFamilyNameAr: String,
    val demFirstNameAr: String,
    val demSecondNameAr: String,
    val demThirdNameAr: String,
    val demDateOfBirth: String,
    val demGender: String,
    val demMaritalStatus: MaritalStatus,
    val demNationality: Nationality
)

data class IDType(
    val typeID: Int,
    val typeNameEN: String,
    val typeNameAR: String,
    val idTypeCode: String
)

data class ApplicantType(
    val applicantTypeID: Int,
    val applicantTypeCode: String,
    val applicantTypeNameEN: String,
    val applicantTypeNameAR: String
)

data class MaritalStatus(
    val matrialStatusId: Int,
    val statusNameEN: String,
    val statusNameAR: String,
    val maritalStatusCode: String
)

data class Nationality(
    val couid: Int,
    val couNameEN: String,
    val couNameAR: String,
    val couCode: String?
)

data class MemberType(
    val id: Int,
    val code: String,
    val nameAr: String,
    val name: String
)

data class Status(
    val id: Int,
    val code: String,
    val nameAr: String,
    val name: String
)

data class PrevEnquiry(
    val prevEnqDate: String,
    val preEnqType: EnquiryType,
    val prevEnqEnquirer: Enquirer,
    val prevEnqMemberRef: String,
    val prevEnquirerName: String,
    val prevEnquirerNameAr: String,
    val prevEnqProductTypeDesc: ProductTypeDesc,
    val prevEnqAmount: Double,
    val otherReason: String?
)

data class EnquiryType(
    val enqTypeCode: String,
    val enqTypeDescriptionAr: String,
    val enqTypeDescriptionEn: String
)

data class Enquirer(
    val memberCode: String?,
    val memberNameEN: String,
    val memberNameAR: String
)

data class ProductTypeDesc(
    val productId: Int,
    val code: String,
    val textEn: String,
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

