package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.*

// Request Data Class
data class BasicInfo(
    val enquiryTypeId: String,
    val idIssuerID: String,
    val amount: String,
    val cityId: String,
    val productId: String,
    val creditInstrumentId: String,
    val idNumber: String,
    val memberRefNo: String
)

data class GeneralInfo(
    val expiryDate: String,
    val isHijriDate: String,
    val nationality: String,
    val familyName: String,
    val firstName: String,
    val secondName: String,
    val thirdName: String,
    val gender: String,
    val dateOfBirth: String,
    val isHijriDateOfBirth: String,
    val name: String,
    val legalId: String,
    val activityId: String,
    val noOfEmployeesId: String
)

data class ContactSimahCorp(
    val contactType: String,
    val areaCode: String,
    val phoneNumber: String,
    val extension: String,
    val countryCode: String
)

data class AddressInfo(
    val addressType: String,
    val street: String,
    val buildingNumber: String,
    val zipCode: String,
    val additionalNumber: String,
    val city: String,
    val district: String
)

data class SimahCorpRequest(
    val basicInfo: BasicInfo,
    val generalInfo: GeneralInfo,
    val contacts: List<ContactSimahCorp>,
    val addressInfo: AddressInfo,
    val isNationalId: String
)

// Response Data Classes
data class EnquiryTypeSimahCorp(
    val enqTypeCode: String,
    val enqTypeDescriptionAr: String,
    val enqTypeDescriptionEn: String
)

data class ProductType(
    val productId: Int,
    val code: String,
    val textEn: String,
    val textAr: String
)

data class CreditFacility(
    val code: String,
    val nameEn: String,
    val nameAr: String
)

data class IssuerSimahCorp(
    val idIssuerCode: String,
    val idIssuerNameEN: String,
    val idIsuuerNameAR: String
)

data class City(
    val cityID: Int,
    val cityNameEN: String,
    val cityNameAR: String,
    val cityCode: String
)

data class LegalForm(
    val legalFormCode: String,
    val legalFormNameEN: String,
    val legalFormNameAR: String
)

data class BusinessActivity(
    val industryNameEN: String,
    val industryNameAR: String
)

data class DemographicsDetail(
    val name: String?,
    val nameAr: String,
    val date: String,
    val issuer: IssuerSimahCorp,
    val idCode: String,
    val isscit: City,
    val expDate: String,
    val legalForm: LegalForm,
    val dateEstablished: String,
    val businessActivity: BusinessActivity,
    val capital: String,
    val nationalNo: String
)

data class Enquiry(
    val enquiryDate: String,
    val enquirer: EnquirerSimahCorp,
    val enquiryType: EnquiryTypeSimahCorp,
    val memberReference: String,
    val product: ProductType,
    val amount: String
)

data class EnquirerSimahCorp(
    val memberCode: String,
    val memberNameEN: String,
    val memberNameAR: String
)

data class SimahCorpResponse(
    val message: String,
    val isSuccess: Boolean,
    val data: Data
)

data class Data(
    val companyResponseJson: CompanyResponseJson,
    val referenceNumber: String
)

data class CompanyResponseJson(
    val reportDetail: ReportDetail,
    val demographicsDetail: DemographicsDetail,
    val previousEnquiries: List<Enquiry>,
    val creditInstrumentSummary: CreditInstrumentSummary,
    val facilitiesSummaryLevel: FacilitiesSummaryLevel,
    val creditInstrumentDetailsMasterViews: List<Any>,
    val serviceCreditInstrumentDetailsMasterViews: List<Any>,
    val serviceCreditInstrumentSummary: List<Any>,
    val nonBorrowingLimits: Any?,
    val tradeCreditSalesCiPayablesSummary: Any?,
    val tradeCreditSalesPayableDetails: List<Any>,
    val tradeCreditSalesCiReceivablesSummary: Any?,
    val tradeCreditReceiveablesDetails: List<Any>,
    val defaults: Any?,
    val companyBouncedCheques: Any?,
    val keyStakeHolders: Any?,
    val guarantorKeyStakeHolders: Any?,
    val corporateOwnership: CorporateOwnership,
    val judgements: List<Any>,
    val narratives: List<Any>,
    val asNarrative: List<Any>
)

data class ReportDetail(
    val reportDate: String,
    val enquiryType: EnquiryTypeSimahCorp,
    val productType: ProductType,
    val enquiryNumber: String,
    val referenceNumber: String,
    val amount: String,
    val creditFacility: CreditFacility,
    val governmentGuaranteed: String
)

data class CreditInstrumentSummary(
    val nonFunded: Any?,
    val funded: Any?,
    val totalLimit: Any?,
    val totalUtilization: Any?,
    val totalPastDue: String
)

data class FacilitiesSummaryLevel(
    val levelOneCISummary: List<Any>,
    val levelTwoCISummary: List<Any>
)

data class CorporateOwnership(
    val parents: List<Any>,
    val subsidiarieses: List<Any>
)


// Controller for SIMAH_CORP
@RestController
class ControllerSimahCorp {

    @PostMapping("/simahcorp")
    fun handleRequest(@RequestBody request: SimahCorpRequest): SimahCorpResponse {
        return SimahCorpResponse(
            message = "",
            isSuccess = true,
            data = Data(
                companyResponseJson = CompanyResponseJson(
                    reportDetail = ReportDetail(
                        reportDate = "16/02/2024 18.30.30",
                        enquiryType = EnquiryTypeSimahCorp(
                            enqTypeCode = "NA",
                            enqTypeDescriptionAr = "طلب جديد",
                            enqTypeDescriptionEn = "New Application"
                        ),
                        productType = ProductType(
                            productId = 139,
                            code = "NFR",
                            textEn = "New facilities request",
                            textAr = "طلب تسهيلات جديدة"
                        ),
                        enquiryNumber = "49239480",
                        referenceNumber = "200667EQ120",
                        amount = "800,000.00",
                        creditFacility = CreditFacility(
                            code = "A",
                            nameEn = "All active credit Instruments",
                            nameAr = "الحسابات الائتمانية الفعالة"
                        ),
                        governmentGuaranteed = "No"
                    ),
                    demographicsDetail = DemographicsDetail(
                        name = null,
                        nameAr = "شركة الفا العربية للتمويل قابضة",
                        date = "29/08/2023",
                        issuer = IssuerSimahCorp(
                            idIssuerCode = "MC",
                            idIssuerNameEN = "Ministry of Commerce and Investment",
                            idIsuuerNameAR = "وزارة التجارة والاستثمار"
                        ),
                        idCode = "1010887286",
                        isscit = City(
                            cityID = 1,
                            cityNameEN = "Riyadh",
                            cityNameAR = "الرياض",
                            cityCode = "RIY"
                        ),
                        expDate = "14/04/2028",
                        legalForm = LegalForm(
                            legalFormCode = "JSC",
                            legalFormNameEN = "Joint Stock Company",
                            legalFormNameAR = "شركة مساهمة"
                        ),
                        dateEstablished = "08/06/2023",
                        businessActivity = BusinessActivity(
                            industryNameEN = "Agriculture, Hunting & Related Service Activities",
                            industryNameAR = "الزراعة، نشاطات خدمةِ مُتَعقِّبةِ وذات علاقة"
                        ),
                        capital = "0.0",
                        nationalNo = "7034107420"
                    ),
                    previousEnquiries = listOf(
                        Enquiry(
                            enquiryDate = "16/02/2024",
                            enquirer = EnquirerSimahCorp(
                                memberCode = "AAHA",
                                memberNameEN = "Alpha Arabia Finance",
                                memberNameAR = "شركة الفا العربية للتمويل قابضة"
                            ),
                            enquiryType = EnquiryTypeSimahCorp(
                                enqTypeCode = "NA",
                                enqTypeDescriptionAr = "طلب جديد",
                                enqTypeDescriptionEn = "New Application"
                            ),
                            memberReference = "200667EQ122",
                            product = ProductType(
                                productId = 139,
                                code = "NFR",
                                textEn = "New facilities request",
                                textAr = "طلب تسهيلات جديدة"
                            ),
                            amount = "6,000,000.00"
                        ),
                        // Add other previous enquiries as needed
                    ),
                    creditInstrumentSummary = CreditInstrumentSummary(
                        nonFunded = null,
                        funded = null,
                        totalLimit = null,
                        totalUtilization = null,
                        totalPastDue = "0.00"
                    ),
                    facilitiesSummaryLevel = FacilitiesSummaryLevel(
                        levelOneCISummary = emptyList(),
                        levelTwoCISummary = emptyList()
                    ),
                    creditInstrumentDetailsMasterViews = emptyList(),
                    serviceCreditInstrumentDetailsMasterViews = emptyList(),
                    serviceCreditInstrumentSummary = emptyList(),
                    nonBorrowingLimits = null,
                    tradeCreditSalesCiPayablesSummary = null,
                    tradeCreditSalesPayableDetails = emptyList(),
                    tradeCreditSalesCiReceivablesSummary = null,
                    tradeCreditReceiveablesDetails = emptyList(),
                    defaults = null,
                    companyBouncedCheques = null,
                    keyStakeHolders = null,
                    guarantorKeyStakeHolders = null,
                    corporateOwnership = CorporateOwnership(
                        parents = emptyList(),
                        subsidiarieses = emptyList()
                    ),
                    judgements = emptyList(),
                    narratives = emptyList(),
                    asNarrative = emptyList()
                ),
                referenceNumber = "200667EQ120"
            )
        )
    }
}
