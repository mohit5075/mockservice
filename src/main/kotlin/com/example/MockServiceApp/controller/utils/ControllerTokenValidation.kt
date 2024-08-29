package com.example.MockServiceApp.controller.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// Request Data Class

data class TokenValidationRequestBody(
    @JsonProperty("tenant-id")
    val tenantId: String,
    @JsonProperty("accessToken")
    val accessToken: String
)

fun decodeJWT(token: String): DecodedJWT {
    return JWT.decode(token)
}

class TokenValidationException(message: String) : RuntimeException(message)

// Controller for Token Validation
@RestController
class ControllerTokenValidation {

    @PostMapping("/tokenValidation")
    fun checkCallback(@RequestBody request: TokenValidationRequestBody): ResponseEntity<String>{
        // Decode the JWT
        val jwt = JWT.decode(request.accessToken)

        // Extract the tenant-id from the "metadata" object in the payload
        val tenantIdFromToken = jwt.getClaim("metadata").asMap()?.get("tenant-id") as? String
        // Compare the tenant-id in the request body with the one in the token
        if (tenantIdFromToken != null) {
            if (tenantIdFromToken.trim() != request.tenantId.trim()) {
                return ResponseEntity("tenant-id is not matching", HttpStatus.UNAUTHORIZED)
            }else {
                return ResponseEntity("Success Token is valid and tenant-id is matching", HttpStatus.OK)
            }
        }else{
            return ResponseEntity("Token Invalid", HttpStatus.UNAUTHORIZED)
        }
    }
}
