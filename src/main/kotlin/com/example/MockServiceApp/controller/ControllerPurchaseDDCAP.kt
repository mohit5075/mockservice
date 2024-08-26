package com.example.MockServiceApp.controller

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

// Request Data Class
data class PurchaseDDCAPRequest(
    @JsonProperty("tran_bank_code")
    val tran_bank_code: String,

    @JsonProperty("tran_client_code")
    val tran_client_code: String,

    @JsonProperty("tran_deal_type")
    val tran_deal_type: String,

    @JsonProperty("tran_class")
    val tran_class: String,

    @JsonProperty("tran_settlement_date")
    val tran_settlement_date: String,

    @JsonProperty("tran_maturity_date")
    val tran_maturity_date: String,

    @JsonProperty("tran_currency")
    val tran_currency: String,

    @JsonProperty("tran_principal")
    val tran_principal: String,

    @JsonProperty("tran_your_reference")
    val tran_your_reference: String,

    @JsonProperty("tran_commodity")
    val tran_commodity: String,

    @JsonProperty("compApplId")
    val compApplId: String,

    @JsonProperty("docId")
    val docId: String,

    @JsonProperty("scanned")
    val scanned: String
)

// Response Data Classes
data class PurchaseDDCAPResponseData(
    @JsonProperty("tran_currency") val tran_currency: String,
    @JsonProperty("tran_bcdt_code") val tran_bcdt_code: String,
    @JsonProperty("tran_settlement_date") val tran_settlement_date: String,
    @JsonProperty("tran_original_maturity_date") val tran_original_maturity_date: String,
    @JsonProperty("tran_deferred_price") val tran_deferred_price: Double,
    @JsonProperty("tran_extra_reference2") val tran_extra_reference2: String,
    @JsonProperty("tran_input_timestamp") val tran_input_timestamp: String,
    @JsonProperty("tran_original_key") val tran_original_key: String,
    @JsonProperty("tran_next_stage") val tran_next_stage: String,
    @JsonProperty("tran_extra_reference1") val tran_extra_reference1: String,
    @JsonProperty("documents_uri") val documents_uri: String,
    @JsonProperty("tran_original_trade_date") val tran_original_trade_date: String,
    @JsonProperty("tran_fee_usd") val tran_fee_usd: String,
    @JsonProperty("tran_deferred_amount") val tran_deferred_amount: Double,
    @JsonProperty("tran_principal") val tran_principal: Double,
    @JsonProperty("tran_structure_code") val tran_structure_code: String,
    @JsonProperty("tran_dept") val tran_dept: String,
    @JsonProperty("tran_quantity_unit") val tran_quantity_unit: String,
    @JsonProperty("tran_end_buyer") val tran_end_buyer: String,
    @JsonProperty("transaction_no") val transaction_no: String,
    @JsonProperty("tran_client_code") val tran_client_code: String,
    @JsonProperty("tran_agreed_profit_rate") val tran_agreed_profit_rate: String,
    @JsonProperty("tran_commodity") val tran_commodity: String,
    @JsonProperty("tran_cycle_identifier") val tran_cycle_identifier: String,
    @JsonProperty("tran_price") val tran_price: Double,
    @JsonProperty("tran_class") val tran_class: String,
    @JsonProperty("transaction_key") val transaction_key: String,
    @JsonProperty("tran_client_name") val tran_client_name: String,
    @JsonProperty("tran_trade_date") val tran_trade_date: String,
    @JsonProperty("tenor") val tenor: String,
    @JsonProperty("sub_transaction_no") val sub_transaction_no: String,
    @JsonProperty("tran_stage_code") val tran_stage_code: String,
    @JsonProperty("tran_fee_exchange_rate") val tran_fee_exchange_rate: String,
    @JsonProperty("tran_maturity_date") val tran_maturity_date: String,
    @JsonProperty("bcdt_uri") val bcdt_uri: String,
    @JsonProperty("tran_input_user") val tran_input_user: String,
    @JsonProperty("tran_exchange_rate_inverse") val tran_exchange_rate_inverse: String,
    @JsonProperty("tran_bank_code") val tran_bank_code: String,
    @JsonProperty("tran_initial_seller") val tran_initial_seller: String,
    @JsonProperty("tran_total_principal") val tran_total_principal: Double,
    @JsonProperty("tran_your_reference") val tran_your_reference: String,
    @JsonProperty("tran_branch") val tran_branch: String,
    @JsonProperty("tran_exchange_rate") val tran_exchange_rate: String,
    @JsonProperty("tran_fee_currency") val tran_fee_currency: String,
    @JsonProperty("tran_original_settlement_date") val tran_original_settlement_date: String,
    @JsonProperty("tran_quantity") val tran_quantity: Double,
    @JsonProperty("tran_outstanding_quantity") val tran_outstanding_quantity: Double,
    @JsonProperty("principal_plus_comm") val principal_plus_comm: String,
    @JsonProperty("original_deal_uri") val original_deal_uri: String,
    @JsonProperty("uri") val uri: String,
    @JsonProperty("tran_outstanding_principal") val tran_outstanding_principal: Double,
    @JsonProperty("tran_comdty_alloc_number") val tran_comdty_alloc_number: String,
    @JsonProperty("tran_fee") val tran_fee: String,
    @JsonProperty("location_rule") val location_rule: String,
    @JsonProperty("tran_tre_type") val tran_tre_type: String,
    @JsonProperty("tran_deal_type") val tran_deal_type: String,
    @JsonProperty("tran_total_quantity") val tran_total_quantity: Double
)

data class PurchaseDDCAPResponse(
    @JsonProperty("success") val success: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("errorCode") val errorCode: String,
    @JsonProperty("Status") val Status: String,
    @JsonProperty("data") val data: PurchaseDDCAPResponseData
)

// Controller for PurchaseDDCAP
@RestController
class ControllerPurchaseDDCAP {

    @PostMapping("/purchaseddcap")
    fun handleRequest(@RequestBody request: PurchaseDDCAPRequest): PurchaseDDCAPResponse {
        return PurchaseDDCAPResponse(
            success = true,
            message = "",
            errorCode = "ER-00",
            Status = "",
            data = PurchaseDDCAPResponseData(
                tran_currency = "SAR",
                tran_bcdt_code = "ALPHA_CLIENT_FINANCING_API_DDC",
                tran_settlement_date = "18 Jan 2024",
                tran_original_maturity_date = "19 Jan 2024",
                tran_deferred_price = 0.0,
                tran_extra_reference2 = "",
                tran_input_timestamp = "17 Jan 2024 06:53:52",
                tran_original_key = "ALPHA_2155143_000001",
                tran_next_stage = "ALPHA_STAGE2",
                tran_extra_reference1 = "",
                documents_uri = "https://afp.ddcap.com/api/deals/ALPHA_2155143_000001/documents/",
                tran_original_trade_date = "17 Jan 2024",
                tran_fee_usd = "0.00",
                tran_deferred_amount = 0.0,
                tran_principal = 15000.0,
                tran_structure_code = "ALPHA_structure",
                tran_dept = "",
                tran_quantity_unit = "Troy Ounces",
                tran_end_buyer = "Condor Trade Limited",
                transaction_no = "2155143",
                tran_client_code = "CLIENT",
                tran_agreed_profit_rate = "",
                tran_commodity = "PDZ",
                tran_cycle_identifier = "",
                tran_price = 3750.0,
                tran_class = "STANDARD",
                transaction_key = "ALPHA_2155143_000001",
                tran_client_name = "Client",
                tran_trade_date = "17 Jan 2024",
                tenor = "1",
                sub_transaction_no = "1",
                tran_stage_code = "ALPHA_STAGE1",
                tran_fee_exchange_rate = "0.00000000",
                tran_maturity_date = "19 Jan 2024",
                bcdt_uri = "https://afp.ddcap.com/api/bcdts/ALPHA_CLIENT_FINANCING_API_DDC",
                tran_input_user = "ALPHA_prod_API (ALPHA_production_API)",
                tran_exchange_rate_inverse = "",
                tran_bank_code = "ALPHA",
                tran_initial_seller = "DD&Co Limited",
                tran_total_principal = 15000.0,
                tran_your_reference = "17-01-2024 06:53:48",
                tran_branch = "",
                tran_exchange_rate = "3.75000000 SAR = 1 USD ",
                tran_fee_currency = "",
                tran_original_settlement_date = "18 Jan 2024",
                tran_quantity = 4.0,
                tran_outstanding_quantity = 4.0,
                principal_plus_comm = "0.00",
                original_deal_uri = "https://afp.ddcap.com/api/deals/ALPHA_2155143_000001",
                uri = "https://afp.ddcap.com/api/deals/ALPHA_2155143_000001",
                tran_outstanding_principal = 15000.0,
                tran_comdty_alloc_number = "65188 2155143 PDZ",
                tran_fee = "0",
                location_rule = "In vault, Zurich",
                tran_tre_type = "Original Deal",
                tran_deal_type = "FINANCING_API",
                tran_total_quantity = 4.0
            )
        )
    }
}
