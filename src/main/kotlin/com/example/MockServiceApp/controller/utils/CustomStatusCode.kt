package com.example.MockServiceApp.controller.utils

data class CustomStatusCode(
    val taskName: String,
    val statusCode: Int
) {
    companion object {
        // Define some custom status codes
        const val TOKEN_VALIDATION_FAILURE = 403
        const val GENERAL_FAILURE = 500
        const val TEMPLATE_VALIDATION_FAILURE = 400

        fun getStatusCode(taskName: String): Int {
            return when (taskName) {
                "Token Validation" -> TOKEN_VALIDATION_FAILURE
                "Schema Validation" -> TEMPLATE_VALIDATION_FAILURE
                else -> GENERAL_FAILURE
            }
        }
    }
}
