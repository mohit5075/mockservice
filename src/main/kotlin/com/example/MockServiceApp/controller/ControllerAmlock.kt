package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestAmLock(
    @JsonProperty("requestId")
    val requestId: String,

    @JsonProperty("prospectType")
    val prospectType: String,

    @JsonProperty("prospectId")
    val prospectId: String,

    @JsonProperty("prospectName")
    val prospectName: String,

    @JsonProperty("countryofNationality")
    val countryofNationality: String,

    @JsonProperty("prospectIdentityNumber")
    val prospectIdentityNumber: String,

    @JsonProperty("dateofBirth")
    val dateofBirth: String,

    @JsonProperty("countryofResidence")
    val countryofResidence: String
)

data class MatchDetail(
    @JsonProperty("sourceField")
    val sourceField: String,

    @JsonProperty("sourceData")
    val sourceData: String,

    @JsonProperty("matchField")
    val matchField: String,

    @JsonProperty("matchData")
    val matchData: String,

    @JsonProperty("listId")
    val listId: String,

    @JsonProperty("matchScore")
    val matchScore: String,

    @JsonProperty("listName")
    val listName: String
)

data class ResponseAmLock(
    @JsonProperty("responseCode")
    val responseCode: String,

    @JsonProperty("requestId")
    val requestId: String,

    @JsonProperty("prospectId")
    val prospectId: String,

    @JsonProperty("message")
    val message: String,

    @JsonProperty("matchDetails")
    val matchDetails: List<MatchDetail>
)

@RestController
class ControllerAmlock {
    @PostMapping("/amlock")
    fun handleRequest(@RequestBody request: RequestAmLock): ResponseAmLock {
        // You can add any processing logic here if needed

        // Return a mock response
        return ResponseAmLock(
            responseCode = "0",
            requestId = "22878",
            prospectId = "196",
            message = "Match Found",
            matchDetails = listOf(
                MatchDetail(
                    sourceField = "prospectName",
                    sourceData = "Sheik Ahmed  Ismail  YASSIN",
                    matchField = "NAME",
                    matchData = "  Sheik Ahmed Ismail  YASSIN  ",
                    listId = "2691",
                    matchScore = "100",
                    listName = "OFACSDN"
                )
            )
        )
    }
}