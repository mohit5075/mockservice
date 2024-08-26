package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

// Request Data Class
data class BasicInfo(
    @JsonProperty("enquiryTypeId")
    val enquiryTypeId: String,

    @JsonProperty("idIssuerID")
    val idIssuerID: String,

    @JsonProperty("amount")
    val amount: String,

    @JsonProperty("cityId")
    val cityId: String,

    @JsonProperty("productId")
    val productId: String,

    @JsonProperty("creditInstrumentId")
    val creditInstrumentId: String,

    @JsonProperty("idNumber")
    val idNumber: String,

    @JsonProperty("memberRefNo")
    val memberRefNo: String
)

data class GeneralInfo(
    @JsonProperty("expiryDate")
    val expiryDate: String,

    @JsonProperty("isHijriDate")
    val isHijriDate: String,

    @JsonProperty("nationality")
    val nationality: String,

    @JsonProperty("familyName")
    val familyName: String,

    @JsonProperty("firstName")
    val firstName: String,

    @JsonProperty("secondName")
    val secondName: String,

    @JsonProperty("thirdName")
    val thirdName: String,

    @JsonProperty("gender")
    val gender: String,

    @JsonProperty("dateOfBirth")
    val dateOfBirth: String,

    @JsonProperty("isHijriDateOfBirth")
    val isHijriDateOfBirth: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("legalId")
    val legalId: String,

    @JsonProperty("activityId")
    val activityId: String,

    @JsonProperty("noOfEmployeesId")
    val noOfEmployeesId: String
)

data class ContactSimahCorp(
    @JsonProperty("contactType")
    val contactType: String,

    @JsonProperty("areaCode")
    val areaCode: String,

    @JsonProperty("phoneNumber")
    val phoneNumber: String,

    @JsonProperty("extension")
    val extension: String,

    @JsonProperty("countryCode")
    val countryCode: String
)

data class AddressInfo(
    @JsonProperty("addressType")
    val addressType: String,

    @JsonProperty("street")
    val street: String,

    @JsonProperty("buildingNumber")
    val buildingNumber: String,

    @JsonProperty("zipCode")
    val zipCode: String,

    @JsonProperty("additionalNumber")
    val additionalNumber: String,

    @JsonProperty("city")
    val city: String,

    @JsonProperty("district")
    val district: String
)

data class SimahCorpRequest(
    @JsonProperty("basicInfo")
    val basicInfo: BasicInfo,

    @JsonProperty("generalInfo")
    val generalInfo: GeneralInfo,

    @JsonProperty("contacts")
    val contacts: List<ContactSimahCorp>,

    @JsonProperty("addressInfo")
    val addressInfo: AddressInfo,

    @JsonProperty("isNationalId")
    val isNationalId: String
)

data class EnquiryTypeSimahCorp(
    @JsonProperty("enqTypeCode") val enqTypeCode: String,
    @JsonProperty("enqTypeDescriptionAr") val enqTypeDescriptionAr: String,
    @JsonProperty("enqTypeDescriptionEn") val enqTypeDescriptionEn: String
)

data class ProductType(
    @JsonProperty("productId") val productId: Int,
    @JsonProperty("code") val code: String,
    @JsonProperty("textEn") val textEn: String,
    @JsonProperty("textAr") val textAr: String
)

data class CreditFacility(
    @JsonProperty("code") val code: String,
    @JsonProperty("nameEn") val nameEn: String,
    @JsonProperty("nameAr") val nameAr: String
)

data class IssuerSimahCorp(
    @JsonProperty("idIssuerCode") val idIssuerCode: String,
    @JsonProperty("idIssuerNameEN") val idIssuerNameEN: String,
    @JsonProperty("idIsuuerNameAR") val idIsuuerNameAR: String
)

data class City(
    @JsonProperty("cityID") val cityID: Int,
    @JsonProperty("cityNameEN") val cityNameEN: String,
    @JsonProperty("cityNameAR") val cityNameAR: String,
    @JsonProperty("cityCode") val cityCode: String
)

data class LegalForm(
    @JsonProperty("legalFormCode") val legalFormCode: String,
    @JsonProperty("legalFormNameEN") val legalFormNameEN: String,
    @JsonProperty("legalFormNameAR") val legalFormNameAR: String
)

data class BusinessActivity(
    @JsonProperty("industryNameEN") val industryNameEN: String,
    @JsonProperty("industryNameAR") val industryNameAR: String
)

data class DemographicsDetail(
    @JsonProperty("name") val name: String?,
    @JsonProperty("nameAr") val nameAr: String,
    @JsonProperty("date") val date: String,
    @JsonProperty("issuer") val issuer: IssuerSimahCorp,
    @JsonProperty("idCode") val idCode: String,
    @JsonProperty("isscit") val isscit: City,
    @JsonProperty("expDate") val expDate: String,
    @JsonProperty("legalForm") val legalForm: LegalForm,
    @JsonProperty("dateEstablished") val dateEstablished: String,
    @JsonProperty("businessActivity") val businessActivity: BusinessActivity,
    @JsonProperty("capital") val capital: String,
    @JsonProperty("nationalNo") val nationalNo: String
)

data class Enquiry(
    @JsonProperty("enquiryDate") val enquiryDate: String,
    @JsonProperty("enquirer") val enquirer: EnquirerSimahCorp,
    @JsonProperty("enquiryType") val enquiryType: EnquiryTypeSimahCorp,
    @JsonProperty("memberReference") val memberReference: String,
    @JsonProperty("product") val product: ProductType,
    @JsonProperty("amount") val amount: String
)

data class EnquirerSimahCorp(
    @JsonProperty("memberCode") val memberCode: String,
    @JsonProperty("memberNameEN") val memberNameEN: String,
    @JsonProperty("memberNameAR") val memberNameAR: String
)

data class SimahCorpResponse(
    @JsonProperty("message") val message: String,
    @JsonProperty("isSuccess") val isSuccess: Boolean,
    @JsonProperty("data") val data: Data
)

data class Data(
    @JsonProperty("companyResponseJson") val companyResponseJson: CompanyResponseJson,
    @JsonProperty("referenceNumber") val referenceNumber: String
)

data class CompanyResponseJson(
    @JsonProperty("reportDetail") val reportDetail: ReportDetail,
    @JsonProperty("demographicsDetail") val demographicsDetail: DemographicsDetail,
    @JsonProperty("previousEnquiries") val previousEnquiries: List<Enquiry>,
    @JsonProperty("creditInstrumentSummary") val creditInstrumentSummary: CreditInstrumentSummary,
    @JsonProperty("facilitiesSummaryLevel") val facilitiesSummaryLevel: FacilitiesSummaryLevel,
    @JsonProperty("creditInstrumentDetailsMasterViews") val creditInstrumentDetailsMasterViews: List<Any>,
    @JsonProperty("serviceCreditInstrumentDetailsMasterViews") val serviceCreditInstrumentDetailsMasterViews: List<Any>,
    @JsonProperty("serviceCreditInstrumentSummary") val serviceCreditInstrumentSummary: List<Any>,
    @JsonProperty("nonBorrowingLimits") val nonBorrowingLimits: Any?,
    @JsonProperty("tradeCreditSalesCiPayablesSummary") val tradeCreditSalesCiPayablesSummary: Any?,
    @JsonProperty("tradeCreditSalesPayableDetails") val tradeCreditSalesPayableDetails: List<Any>,
    @JsonProperty("tradeCreditSalesCiReceivablesSummary") val tradeCreditSalesCiReceivablesSummary: Any?,
    @JsonProperty("tradeCreditReceiveablesDetails") val tradeCreditReceiveablesDetails: List<Any>,
    @JsonProperty("defaults") val defaults: Any?,
    @JsonProperty("companyBouncedCheques") val companyBouncedCheques: Any?,
    @JsonProperty("keyStakeHolders") val keyStakeHolders: Any?,
    @JsonProperty("guarantorKeyStakeHolders") val guarantorKeyStakeHolders: Any?,
    @JsonProperty("corporateOwnership") val corporateOwnership: CorporateOwnership,
    @JsonProperty("judgements") val judgements: List<Any>,
    @JsonProperty("narratives") val narratives: List<Any>,
    @JsonProperty("asNarrative") val asNarrative: List<Any>
)

data class ReportDetail(
    @JsonProperty("reportDate") val reportDate: String,
    @JsonProperty("enquiryType") val enquiryType: EnquiryTypeSimahCorp,
    @JsonProperty("productType") val productType: ProductType,
    @JsonProperty("enquiryNumber") val enquiryNumber: String,
    @JsonProperty("referenceNumber") val referenceNumber: String,
    @JsonProperty("amount") val amount: String,
    @JsonProperty("creditFacility") val creditFacility: CreditFacility,
    @JsonProperty("governmentGuaranteed") val governmentGuaranteed: String
)

data class CreditInstrumentSummary(
    @JsonProperty("nonFunded") val nonFunded: Any?,
    @JsonProperty("funded") val funded: Any?,
    @JsonProperty("totalLimit") val totalLimit: Any?,
    @JsonProperty("totalUtilization") val totalUtilization: Any?,
    @JsonProperty("totalPastDue") val totalPastDue: String
)

data class FacilitiesSummaryLevel(
    @JsonProperty("levelOneCISummary") val levelOneCISummary: List<Any>,
    @JsonProperty("levelTwoCISummary") val levelTwoCISummary: List<Any>
)

data class CorporateOwnership(
    @JsonProperty("parents") val parents: List<Any>,
    @JsonProperty("subsidiarieses") val subsidiarieses: List<Any>
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
