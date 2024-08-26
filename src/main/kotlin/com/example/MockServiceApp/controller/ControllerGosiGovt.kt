package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestGosiGovt(
    val customerId: String,
    val birthDate: String
)

data class PersonalInfo(
    val employeeNameAr: String,
    val employeeNameEn: String
)

data class EmployerInfo(
    val agencyCode: String,
    val agencyName: String
)

data class BankInfo(
    val accountNumber: String,
    val bankCode: String,
    val bankName: String
)

data class EmploymentInfo(
    val employeeJobNumber: String,
    val employeeJobTitle: String,
    val agencyEmploymentDate: String
)

data class PayslipInfo(
    val payMonth: String,
    val basicSalary: String,
    val totalAllownces: String,
    val totalDeductions: String,
    val netSalary: String
)

data class DataItem(
    val personalInfo: PersonalInfo,
    val employerInfo: EmployerInfo,
    val bankInfo: BankInfo,
    val employmentInfo: EmploymentInfo,
    val payslipInfo: PayslipInfo
)

data class ResponseGosiGovt(
    val requestNumber: String,
    val message: String,
    val data: List<DataItem>
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