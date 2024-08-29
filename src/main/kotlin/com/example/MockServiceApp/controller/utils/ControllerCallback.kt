package com.example.MockServiceApp.controller.utils

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

data class CallbackPayload(
    @JsonProperty("data")
    val data: Any,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("statusCode")
    val statusCode: Int
)
data class CallbackTaskPayload(
    @JsonProperty("callbackurl")
    val callbackurl: String?,
    @JsonProperty("data")
    val data: Any,
    @JsonProperty("trace-id")
    val traceId: String?
)

@RestController
class ControllerCallback( val restTemplate: RestTemplate) {
    @PostMapping("/checkCallback")
    fun checkCallback(@RequestBody requestBody: CallbackTaskPayload):ResponseEntity<String>{
        val url = requestBody.callbackurl
        if(url!=null && url!=""){
            val headers = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
                add("trace-id",requestBody.traceId)
            }
            val transformedBody = CallbackPayload(
                data = requestBody.data,
                message = "SUCCESS",
                statusCode = 200
            )
            val entity = HttpEntity(transformedBody, headers)
            restTemplate.postForObject(url,entity, CallbackPayload::class.java)
            return ResponseEntity("Request sent to callback", HttpStatus.OK)
        }
        return ResponseEntity("callback is not present", HttpStatus.BAD_REQUEST)
    }
}