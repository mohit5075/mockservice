package com.example.MockServiceApp.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class RequestAmLock(
    val requestId: String,
    val prospectType: String,
    val prospectId: String,
    val prospectName: String,
    val countryofNationality: String,
    val prospectIdentityNumber: String,
    val dateofBirth: String,
    val countryofResidence: String
)

data class MatchDetail(
    val sourceField: String,
    val sourceData: String,
    val matchField: String,
    val matchData: String,
    val listId: String,
    val matchScore: String,
    val listName: String
)

data class ResponseAmLock(
    val responseCode: String,
    val requestId: String,
    val prospectId: String,
    val message: String,
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