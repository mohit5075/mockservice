package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

data class RequestSaudiByNin(
    @JsonProperty("nin")
    val nin: String,
    @JsonProperty("dateString")
    val dateString: String
)

data class ResponseSaudiByNin(
    @JsonProperty("personDependents") val personDependents: PersonDependents,
    @JsonProperty("personIdInfo") val personIdInfo: PersonIdInfo,
    @JsonProperty("personBasicInfo") val personBasicInfo: PersonBasicInfo
)

data class PersonDependents(
    @JsonProperty("dependentsCount") val dependentsCount: String
)

data class PersonIdInfo(
    @JsonProperty("idExpirationDate") val idExpirationDate: LocalDateTime
)

data class PersonBasicInfo(
    @JsonProperty("birthDateG") val birthDateG: LocalDateTime,
    @JsonProperty("familyName") val familyName: String,
    @JsonProperty("familyNameT") val familyNameT: String,
    @JsonProperty("fatherName") val fatherName: String,
    @JsonProperty("fatherNameT") val fatherNameT: String,
    @JsonProperty("firstNameT") val firstNameT: String,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("grandFatherName") val grandFatherName: String,
    @JsonProperty("grandFatherNameT") val grandFatherNameT: String,
    @JsonProperty("maritalStatusDescAr") val maritalStatusDescAr: String,
    @JsonProperty("sexDescAr") val sexDescAr: String
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