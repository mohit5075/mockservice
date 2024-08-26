package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestAddressByNin(
    @JsonProperty("nin")
    val nin: String,

    @JsonProperty("dateString")
    val dateString: String
)

data class ResponseAddressByNin(
    @JsonProperty("personNationalAddressInfo")
    val personNationalAddressInfo: PersonNationalAddressInfo
)

data class PersonNationalAddressInfo(
    @JsonProperty("Addresses")
    val Addresses: List<AddressNin>,

    @JsonProperty("PostCode")
    val PostCode: String?
)

data class AddressNin(
    @JsonProperty("ObjLatLng")
    val ObjLatLng: String,

    @JsonProperty("BuildingNumber")
    val BuildingNumber: String,

    @JsonProperty("Street")
    val Street: String,

    @JsonProperty("District")
    val District: String,

    @JsonProperty("City")
    val City: String,

    @JsonProperty("PostCode")
    val PostCode: String,

    @JsonProperty("AdditionalNumber")
    val AdditionalNumber: String,

    @JsonProperty("IsPrimaryAddress")
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
                    AddressNin(
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