package com.example.investcenter.ui.list

   import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.alonsodelcid.investcenter.model.CryptoApiResponse
    import com.alonsodelcid.investcenter.model.CryptoResult
    import com.alonsodelcid.investcenter.service.CryptoApiService
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    class CryptoListViewModel() : ViewModel() {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://fake-server-app-crypto.herokuapp.com/details/ETH/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val service: CryptoApiService = retrofit.create(CryptoApiService::class.java)

        val cryptoList = MutableLiveData<List<CryptoResult>>()

        fun getCryptoList(){
            val call = service.getCryptoList(100,0)

            call.enqueue(object : Callback<CryptoApiResponse>{
                override fun onResponse(call: Call<CryptoApiResponse>,response: Response<CryptoApiResponse>) {
                    response.body()?.results?.let { list ->
                        CryptoList.postValue(list)
                    }

                }

                override fun onFailure(call: Call<CryptoApiResponse>, t: Throwable) {
                    call.cancel()
                }

            })
        }

