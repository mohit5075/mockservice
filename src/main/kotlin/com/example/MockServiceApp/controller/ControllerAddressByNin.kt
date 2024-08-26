package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestAddressByNin(
    val nin: String,
    val dateString: String
)

data class ResponseAddressByNin(
    val personNationalAddressInfo: PersonNationalAddressInfo
)

data class PersonNationalAddressInfo(
    val Addresses: List<Address>,
    val PostCode: String?
)

data class Address(
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
class ControllerAddressByNin {
    @PostMapping("/addressbynin")
    fun handleRequest(@RequestBody request: RequestAddressByNin): ResponseAddressByNin {
        // Mock response with predefined values
        return ResponseAddressByNin(
            personNationalAddressInfo = PersonNationalAddressInfo(
                Addresses = listOf(
                    Address(
                        ObjLatLng = "46.84191378 24.69679989",
                        BuildingNumber = "2796",
                        Street = "Al Taim ",
                        District = "Al Saadah Dist.",
                        City = "RIYADH",
                        PostCode = "14257",
                        AdditionalNumber = "6233",
                        IsPrimaryAddress = "true"
                    )
                ),
                PostCode = null
            )
        )
    }
}