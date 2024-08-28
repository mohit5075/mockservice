package com.example.MockServiceApp.controller.utils

import org.springframework.web.bind.annotation.*

// Request Data Class

data class CallbackPayload(
    val data: Any,
    val message: String
)
data class CallbackTaskData(
    val callbackUrl: String,
    val data: CallbackPayload
)

// Controller for UnifonicSMS
@RestController
class ControllerUtils {

    @PostMapping("/checkCallback")
    fun checkCallback(@RequestBody request: CallbackTaskData): String{
        val url = request.callbackUrl;
        if(url!=null && url!=""){
            //restTemplate

        }
        return "callback url is not present"
    }

    @PostMapping("subworkflow")
    fun executeSubworkflow(@RequestBody)
}
