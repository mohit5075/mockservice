package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

data class RequestSaudiByNin(
    val nin: String,
    val dateString: String
)

data class ResponseSaudiByNin(
    val personDependents: PersonDependents,
    val personIdInfo: PersonIdInfo,
    val personBasicInfo: PersonBasicInfo
)

data class PersonDependents(
    val dependentsCount: String
)

data class PersonIdInfo(
    val idExpirationDate: LocalDateTime
)

data class PersonBasicInfo(
    val birthDateG: LocalDateTime,
    val familyName: String,
    val familyNameT: String,
    val fatherName: String,
    val fatherNameT: String,
    val firstNameT: String,
    val firstName: String,
    val grandFatherName: String,
    val grandFatherNameT: String,
    val maritalStatusDescAr: String,
    val sexDescAr: String
)

@RestController
class ControllerSaudiByNin {
    @PostMapping("/saudibynin")
    fun handleRequest(@RequestBody request: RequestSaudiByNin): ResponseSaudiByNin {
        // Mock response with predefined values
        return ResponseSaudiByNin(
            personDependents = PersonDependents(
                dependentsCount = "4"
            ),
            personIdInfo = PersonIdInfo(
                idExpirationDate = LocalDateTime.parse("2030-04-03T00:00:00")
            ),
            personBasicInfo = PersonBasicInfo(
                birthDateG = LocalDateTime.parse("1978-10-21T00:00:00"),
                familyName = "العتيبي",
                familyNameT = "ALOTAIBI",
                fatherName = "شويط",
                fatherNameT = "SHWAIT",
                firstNameT = "SULTAN",
                firstName = "سلطان",
                grandFatherName = "وقيان",
                grandFatherNameT = "W",
                maritalStatusDescAr = "زوجة واحدة",
                sexDescAr = "ذكر"
            )
        )
    }
}