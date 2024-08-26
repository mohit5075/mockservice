package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestGosiPvt(
    val customerId: String
)

data class EmploymentStatusInfo(
    val fullName: String,
    val basicWage: String,
    val housingAllowance: String,
    val otherAllowance: String,
    val employerName: String,
    val workingMonths: Int,
    val employmentStatus: String,
    val salaryStartingDate: String,
    val establishmentActivity: String?,
    val dateOfJoining: String
)

data class ResponseGosiPvt(
    val requestNumber: String,
    val message: String,
    val employmentStatusInfo: List<EmploymentStatusInfo>
)
@RestController
class ControllerGosiPrivate {
    @PostMapping("/gosiPvt")
    fun handleRequest(@RequestBody request: RequestGosiPvt): ResponseGosiPvt {
        // You can add any processing logic here if needed

        // Return a mock response
        return ResponseGosiPvt(
            requestNumber = "238340cd-40b9-4af8-86a0-daaf16548373",
            message = "Information Retreived from GOSI",
            employmentStatusInfo = listOf(
                EmploymentStatusInfo(
                    fullName = "وليد بن صالح بن ابراهيم الزير",
                    basicWage = "8580.0",
                    housingAllowance = "0.0",
                    otherAllowance = "0.0",
                    employerName = "ادارة اسكان قوى الامن الداخلي بالخ??جي",
                    workingMonths = 459,
                    employmentStatus = "نشيط",
                    salaryStartingDate = "01/01/2022",
                    establishmentActivity = null,
                    dateOfJoining = "26/03/2001"
                )
            )
        )
    }
}