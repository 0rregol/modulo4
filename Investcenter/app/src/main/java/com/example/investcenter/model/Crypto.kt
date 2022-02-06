package com.example.investcenter.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Crypto (
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
    val results: val sprites: Sprites
)
)

data class Sprites (
    val name: String,
    val url: String
)