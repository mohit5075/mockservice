package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

// Request Data Class
data class RequestNonSaudiByIqama(
    @JsonProperty("iqama") val iqama: String,
    @JsonProperty("birthDateG") val birthDateG: String
)

// Response Data Classes
data class ResponseNonSaudiByIqama(
    @JsonProperty("personDependents") val personDependents: PersonDependents2,
    @JsonProperty("personIdInfo") val personIdInfo: PersonIdInfo2,
    @JsonProperty("personBasicInfo") val personBasicInfo: PersonBasicInfo2,
    @JsonProperty("personAlienSponsorInfo") val personAlienSponsorInfo: PersonAlienSponsorInfo
)

data class PersonDependents2(
    @JsonProperty("dependentsCount") val dependentsCount: String
)

data class PersonIdInfo2(
    @JsonProperty("idExpirationDate") val idExpirationDate: String
)

data class PersonBasicInfo2(
    @JsonProperty("birthDateG") val birthDateG: String,
    @JsonProperty("familyName") val familyName: String,
    @JsonProperty("familyNameT") val familyNameT: String,
    @JsonProperty("fatherName") val fatherName: String,
    @JsonProperty("fatherNameT") val fatherNameT: String,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("firstNameT") val firstNameT: String,
    @JsonProperty("grandFatherName") val grandFatherName: String,
    @JsonProperty("grandFatherNameT") val grandFatherNameT: String,
    @JsonProperty("maritalStatusDescAr") val maritalStatusDescAr: String,
    @JsonProperty("nationalityDescAr") val nationalityDescAr: String,
    @JsonProperty("occupationDescAr") val occupationDescAr: String,
    @JsonProperty("sexDescAr") val sexDescAr: String
)

data class PersonAlienSponsorInfo(
    @JsonProperty("businessFirmInfo") val businessFirmInfo: BusinessFirmInfo?,
    @JsonProperty("personBasicInfo") val personBasicInfo: PersonBasicInfo2?
)

data class BusinessFirmInfo(
    @JsonProperty("firmName") val firmName: String
)

@RestController
class ControllerNonSaudiByIqama {
    @PostMapping("/nonsaudibyIqama")
    fun handleRequest(@RequestBody request: RequestNonSaudiByIqama): ResponseNonSaudiByIqama {
        // Mock response with predefined values
        return ResponseNonSaudiByIqama(
            personDependents = PersonDependents2(
                dependentsCount = "2"
            ),
            personIdInfo = PersonIdInfo2(
                idExpirationDate = "2024-02-27T00:00:00"
            ),
            personBasicInfo = PersonBasicInfo2(
                birthDateG = "1975-01-01T00:00:00",
                familyName = "حسين",
                familyNameT = "HUSSAIN",
                fatherName = "ايوب",
                fatherNameT = "AYOUB",
                firstName = "محمد",
                firstNameT = "MOHAMMED",
                grandFatherName = "-",
                grandFatherNameT = "",
                maritalStatusDescAr = "متزوج",
                nationalityDescAr = "الهند",
                occupationDescAr = "أخصائي تسويق",
                sexDescAr = "ذكر"
            ),
            personAlienSponsorInfo = PersonAlienSponsorInfo(
                businessFirmInfo = BusinessFirmInfo(
                    firmName = "شركة التكاملية العالمية التجارية"
                ),
                personBasicInfo = null
            )
        )
    }
}