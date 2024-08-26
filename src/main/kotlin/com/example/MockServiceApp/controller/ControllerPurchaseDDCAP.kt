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
    val tran_currency: String,
    val tran_bcdt_code: String,
    val tran_settlement_date: String,
    val tran_original_maturity_date: String,
    val tran_deferred_price: Double,
    val tran_extra_reference2: String,
    val tran_input_timestamp: String,
    val tran_original_key: String,
    val tran_next_stage: String,
    val tran_extra_reference1: String,
    val documents_uri: String,
    val tran_original_trade_date: String,
    val tran_fee_usd: String,
    val tran_deferred_amount: Double,
    val tran_principal: Double,
    val tran_structure_code: String,
    val tran_dept: String,
    val tran_quantity_unit: String,
    val tran_end_buyer: String,
    val transaction_no: String,
    val tran_client_code: String,
    val tran_agreed_profit_rate: String,
    val tran_commodity: String,
    val tran_cycle_identifier: String,
    val tran_price: Double,
    val tran_class: String,
    val transaction_key: String,
    val tran_client_name: String,
    val tran_trade_date: String,
    val tenor: String,
    val sub_transaction_no: String,
    val tran_stage_code: String,
    val tran_fee_exchange_rate: String,
    val tran_maturity_date: String,
    val bcdt_uri: String,
    val tran_input_user: String,
    val tran_exchange_rate_inverse: String,
    val tran_bank_code: String,
    val tran_initial_seller: String,
    val tran_total_principal: Double,
    val tran_your_reference: String,
    val tran_branch: String,
    val tran_exchange_rate: String,
    val tran_fee_currency: String,
    val tran_original_settlement_date: String,
    val tran_quantity: Double,
    val tran_outstanding_quantity: Double,
    val principal_plus_comm: String,
    val original_deal_uri: String,
    val uri: String,
    val tran_outstanding_principal: Double,
    val tran_comdty_alloc_number: String,
    val tran_fee: String,
    val location_rule: String,
    val tran_tre_type: String,
    val tran_deal_type: String,
    val tran_total_quantity: Double
)

data class PurchaseDDCAPResponse(
    val success: Boolean,
    val message: String,
    val errorCode: String,
    val Status: String,
    val data: PurchaseDDCAPResponseData
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
