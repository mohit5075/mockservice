package com.example.MockServiceApp.controller.utils

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

data class FailedCallbackCheckRequest(
    @JsonProperty("taskName")
    val taskName: String,
    @JsonProperty("callbackurl")
    val callbackurl: String
)

//data class PayloadFailedWorkflow(
//    @JsonProperty("data")
//    val data: Any,
//    @JsonProperty("message")
//    val callbackurl: String
//)

@RestController
class ControllerFailedWorkflow(val restTemplate: RestTemplate) {
    @PostMapping("/failedCallbackCheck")
    fun failedCallbackCheck(@RequestBody requestFailedWorkflow: FailedCallbackCheckRequest):String{
        val url = requestFailedWorkflow.callbackurl
        if(url!=null && url!=""){
            val headers = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            }
            val transformedBody = CallbackPayload(
                data = {},
                message = requestFailedWorkflow.taskName+" failed",
                statusCode = 500
            )
            val entity = HttpEntity(transformedBody, headers)
            restTemplate.postForObject(url,entity, CallbackPayload::class.java)
            return "Request sent to callback"
        }
        return "callbackurl is not present"
    }
}