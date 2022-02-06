package com.example.investcenter.ui.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alonsodelcid.investcenter.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_crypto.*

class CryptoInfoActivity {
    lateinit var viewModel: CryptoInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptoinfo)

        viewModel = ViewModelProvider(this).get(CryptoInfoViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        viewModel.getCryptoInfo(id)

        viewModel.cryptoInfo.observe(this, Observer { crypto->
            nameTextView.text = crypto.name
            priceText.text = "price: ${crypto.height/10.0}m"
            rankText.text = "rank: ${crypto.weight/10.0}"

            Glide.with(this).load(crypto.sprites.frontDefault).into(imageView)
        })
    }
}