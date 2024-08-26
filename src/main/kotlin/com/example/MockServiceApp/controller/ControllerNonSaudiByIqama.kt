package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestNonSaudiByIqama(
    val iqama: String,
    val birthDateG: String
)

data class ResponseNonSaudiByIqama(
    val personDependents: PersonDependents2,
    val personIdInfo: PersonIdInfo2,
    val personBasicInfo: PersonBasicInfo2,
    val personAlienSponsorInfo: PersonAlienSponsorInfo
)

data class PersonDependents2(
    val dependentsCount: String
)

data class PersonIdInfo2(
    val idExpirationDate: String
)

data class PersonBasicInfo2(
    val birthDateG: String,
    val familyName: String,
    val familyNameT: String,
    val fatherName: String,
    val fatherNameT: String,
    val firstName: String,
    val firstNameT: String,
    val grandFatherName: String,
    val grandFatherNameT: String,
    val maritalStatusDescAr: String,
    val nationalityDescAr: String,
    val occupationDescAr: String,
    val sexDescAr: String
)

data class PersonAlienSponsorInfo(
    val businessFirmInfo: BusinessFirmInfo?,
    val personBasicInfo: PersonBasicInfo2?
)

data class BusinessFirmInfo(
    val firmName: String
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