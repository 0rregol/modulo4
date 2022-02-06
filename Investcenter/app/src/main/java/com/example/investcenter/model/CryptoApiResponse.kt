package com.example.investcenter.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CryptoApiResponse (
   val id: Int,
    val currency: String,
   val symbol: String,
     val name: String,
    val logo_url: String,
     val status: Int,
    val price: String,
   val price_date: String,
     val price_timestamp: String,
   val rank: String,
    val results: List<CryptoResult>
)

data class CryptoResult (
   val name: String,
    val url: String
)