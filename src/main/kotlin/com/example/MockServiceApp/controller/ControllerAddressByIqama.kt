package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestAddressByIqama(
    @JsonProperty("iqama")
    val iqama: String,
    
    @JsonProperty("birthDateG")
    val birthDateG: String
)

data class ResponseAddressByIqama(
    @JsonProperty("personNationalAddressInfo")
    val personNationalAddressInfo: PersonNationalAddressInfoIqama
)

data class PersonNationalAddressInfoIqama(
    @JsonProperty("Addresses")
    val Addresses: List<AddressIqama>,
    
    @JsonProperty("PostCode")
    val PostCode: String?
)

data class AddressIqama(
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