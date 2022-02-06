package com.example.investcenter.ui.info


    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.alonsodelcid.investcenter.model.Crypto
    import com.alonsodelcid.investcenter.service.CryptoApiService
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    class CryptoInfoViewModel() : ViewModel() {
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://fake-server-app-crypto.herokuapp.com/general/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val service: CryptoApiService = retrofit.create(CryptoApiService::class.java)

        val pokemonInfo = MutableLiveData<Crypto>()

        fun getCryptonInfo(id: Int){
            val call = service.getPokemonInfo(id)

            call.enqueue(object : Callback<Crypto>{
                override fun onResponse(call: Call<Crypto>, response: Response<Crypto>) {
                    response.body()?.let { crypto ->
                        cryptoInfo.postValue(crypto)
                    }
                }

                override fun onFailure(call: Call<Crypto>, t: Throwable) {
                    call.cancel()
                }

            })
        }
    }