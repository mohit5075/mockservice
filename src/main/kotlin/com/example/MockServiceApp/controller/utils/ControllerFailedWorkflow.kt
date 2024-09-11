package com.example.MockServiceApp.controller.utils

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

data class FailedCallbackCheckRequest(
    @JsonProperty("data")
    val taskNameObject: FailedWorkflowInput,
    @JsonProperty("callbackurl")
    val callbackurl: String?,
    @JsonProperty("trace-id")
    val traceId: String?
)

data class FailedWorkflowInput(
    @JsonProperty("status")
    val status: String,

    @JsonProperty("endTime")
    val endTime: Long,

    @JsonProperty("workflowId")
    val workflowId: String,

    @JsonProperty("tasks")
    val tasks: List<Any>,

    @JsonProperty("reasonForIncompletion")
    val reasonForIncompletion: String,

    @JsonProperty("failedReferenceTaskNames")
    val failedReferenceTaskNames: List<String>,

    @JsonProperty("failedTaskNames")
    val failedTaskNames: List<String>,

    @JsonProperty("workflowDefinition")
    val workflowDefinition: Map<String, Any>,

    @JsonProperty("priority")
    val priority: Int,

    @JsonProperty("variables")
    val variables: Map<String, Any>,

    @JsonProperty("lastRetriedTime")
    val lastRetriedTime: Long,

    @JsonProperty("ownerApp")
    val ownerApp: String,

    @JsonProperty("createTime")
    val createTime: Long,

    @JsonProperty("updatedTime")
    val updatedTime: Long,

    @JsonProperty("failedTaskId")
    val failedTaskId: String,

    @JsonProperty("previousStatus")
    val previousStatus: String,

    @JsonProperty("workflowName")
    val workflowName: String,

    @JsonProperty("workflowVersion")
    val workflowVersion: Int,

    @JsonProperty("input")
    val input: Map<String, Any>,

    @JsonProperty("output")
    val output: Map<String, Any>
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
    fun failedCallbackCheck(@RequestBody requestFailedWorkflow: FailedCallbackCheckRequest): ResponseEntity<ResponseMessage> {
        return try {
            val url = requestFailedWorkflow.callbackurl
            if (url != null && url != "") {
                val headers = HttpHeaders().apply {
                    contentType = MediaType.APPLICATION_JSON
                    add("trace-id", requestFailedWorkflow.traceId)
                }
                val taskname = requestFailedWorkflow.taskNameObject.failedTaskNames[0]
                val transformedBody = CallbackPayload(
                    data = {},
                    message = requestFailedWorkflow.taskNameObject.failedTaskNames[0] + " failed",
                    statusCode = CustomStatusCode.getStatusCode(taskname)
                )
                val entity = HttpEntity(transformedBody, headers)
                restTemplate.postForObject(url, entity, CallbackPayload::class.java)
                return ResponseEntity(ResponseMessage("Request sent to callback"), HttpStatus.OK)
            }
            return ResponseEntity(ResponseMessage("Request sent to callback"), HttpStatus.BAD_REQUEST)
        } catch (ex: Exception) {
            // Return a generic error message if an exception occurs
            ResponseEntity(ResponseMessage("An error occurred: ${ex.message}"), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}