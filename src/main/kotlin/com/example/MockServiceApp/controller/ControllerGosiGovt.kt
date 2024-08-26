package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestGosiGovt(
    @JsonProperty("customerId") val customerId: String,
    @JsonProperty("birthDate") val birthDate: String
)

data class PersonalInfo(
    @JsonProperty("employeeNameAr") val employeeNameAr: String,
    @JsonProperty("employeeNameEn") val employeeNameEn: String
)

data class EmployerInfo(
    @JsonProperty("agencyCode") val agencyCode: String,
    @JsonProperty("agencyName") val agencyName: String
)

data class BankInfo(
    @JsonProperty("accountNumber") val accountNumber: String,
    @JsonProperty("bankCode") val bankCode: String,
    @JsonProperty("bankName") val bankName: String
)

data class EmploymentInfo(
    @JsonProperty("employeeJobNumber") val employeeJobNumber: String,
    @JsonProperty("employeeJobTitle") val employeeJobTitle: String,
    @JsonProperty("agencyEmploymentDate") val agencyEmploymentDate: String
)

data class PayslipInfo(
    @JsonProperty("payMonth") val payMonth: String,
    @JsonProperty("basicSalary") val basicSalary: String,
    @JsonProperty("totalAllownces") val totalAllownces: String,
    @JsonProperty("totalDeductions") val totalDeductions: String,
    @JsonProperty("netSalary") val netSalary: String
)

data class DataItem(
    @JsonProperty("personalInfo") val personalInfo: PersonalInfo,
    @JsonProperty("employerInfo") val employerInfo: EmployerInfo,
    @JsonProperty("bankInfo") val bankInfo: BankInfo,
    @JsonProperty("employmentInfo") val employmentInfo: EmploymentInfo,
    @JsonProperty("payslipInfo") val payslipInfo: PayslipInfo
)

data class ResponseGosiGovt(
    @JsonProperty("requestNumber") val requestNumber: String,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: List<DataItem>
)

@RestController
class ControllerGosiGovt {
    @PostMapping("/gosiGovt")
    fun handleRequest(@RequestBody request: RequestGosiGovt): ResponseGosiGovt {
        // You can add any processing logic here if needed

        // Return a mock response
        return ResponseGosiGovt(
            requestNumber = "3ba94f20-6755-4c16-8378-462d6f90d2b5",
            message = "Informationretrievedfromgovernment",
            data = listOf(
                DataItem(
                    personalInfo = PersonalInfo(
                        employeeNameAr = "سعد",
                        employeeNameEn = "DQ"
                    ),
                    employerInfo = EmployerInfo(
                        agencyCode = "041001000000",
                        agencyName = "وزارةالمالية-الديوانالعام"
                    ),
                    bankInfo = BankInfo(
                        accountNumber = "SA9350000000000523523523",
                        bankCode = "AAAL",
                        bankName = "SaudiHollandiBank"
                    ),
                    employmentInfo = EmploymentInfo(
                        employeeJobNumber = "900aa",
                        employeeJobTitle = "SrTestEng",
                        agencyEmploymentDate = "2018-10-10"
                    ),
                    payslipInfo = PayslipInfo(
                        payMonth = "202008",
                        basicSalary = "1000",
                        totalAllownces = "100",
                        totalDeductions = "100",
                        netSalary = "1000"
                    )
                )
            )
        )
    }
}