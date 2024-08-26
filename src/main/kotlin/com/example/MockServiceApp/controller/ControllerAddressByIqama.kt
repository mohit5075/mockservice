package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestAddressByIqama(
    val iqama: String,
    val birthDateG: String
)

data class ResponseAddressByIqama(
    val personNationalAddressInfo: PersonNationalAddressInfoIqama
)

data class PersonNationalAddressInfoIqama(
    val Addresses: List<AddressIqama>,
    val PostCode: String?
)

data class AddressIqama(
    val ObjLatLng: String,
    val BuildingNumber: String,
    val Street: String,
    val District: String,
    val City: String,
    val PostCode: String,
    val AdditionalNumber: String,
    val IsPrimaryAddress: String
)

@RestController
class ControllerAddressByIqama {
    @PostMapping("/addressbyiqama")
    fun handleRequest(@RequestBody request: RequestAddressByIqama): ResponseAddressByIqama {
        // Mock response with predefined values
        return ResponseAddressByIqama(
            personNationalAddressInfo = PersonNationalAddressInfoIqama(
                Addresses = listOf(
                    AddressIqama(
                        ObjLatLng = "46.71258007 24.67226737",
                        BuildingNumber = "6839",
                        Street = "Al Wahit",
                        District = "Al Wizarat Dist.",
                        City = "RIYADH",
                        PostCode = "12626",
                        AdditionalNumber = "3320",
                        IsPrimaryAddress = "true"
                    ),
                    AddressIqama(
                        ObjLatLng = "46.71258007 24.67226737",
                        BuildingNumber = "6839",
                        Street = "Al Wahit",
                        District = "Al Wizarat Dist.",
                        City = "RIYADH",
                        PostCode = "12626",
                        AdditionalNumber = "3320",
                        IsPrimaryAddress = "false"
                    )
                ),
                PostCode = null
            )
        )
    }
}