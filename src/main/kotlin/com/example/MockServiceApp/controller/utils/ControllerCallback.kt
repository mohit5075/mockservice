package com.example.MockServiceApp.controller.utils

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.client.RestTemplate

data class CallbackPayload(
    @JsonProperty("data")
    val data: Any,
    @JsonProperty("message")
    val message: String
)
data class CallbackTaskPayload(
    @JsonProperty("callbackurl")
    val callbackurl: String,
    @JsonProperty("data")
    val data: Any
)
class ControllerCallback( val restTemplate: RestTemplate) {
    @PostMapping("/checkCallback")
    fun checkCallback(@RequestBody requestBody: CallbackTaskPayload):String{
        val url = requestBody.callbackurl
        if(url!=null && url!=""){
            val headers = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            val transformedBody = CallbackPayload(
                data = requestBody.data,
                message = "SUCCESS"
            )
            val entity = HttpEntity(transformedBody, headers)
            return restTemplate.postForObject(url,entity, CallbackPayload::class.java).toString()
        }
        return "callback is not present"
    }
}