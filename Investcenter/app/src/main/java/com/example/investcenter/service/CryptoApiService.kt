package com.example.investcenter.service


import com.alonsodelcid.investcenter.model.CryptoApiResponse
import com.alonsodelcid.investcenter.model.Crypto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoApiService{
    @GET("crypto/{id}")
    fun getcryptoInfo(@Path("id") id: Int): Call<Crypto>
    @GET("crypto")
    fun getcryptoList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<cryptoApiResponse>
}