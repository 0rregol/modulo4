package com.example.investcenter.ui.list


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsodelcid.investcenter.R
import com.alonsodelcid.investcenter.ui.cryptoinfo.CryptoInfoActivity
import kotlinx.android.synthetic.main.activity_cryptolist.*

class CryptoListActivity : AppCompatActivity() {

    private lateinit var viewModel: CryptoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokelist)

        viewModel = ViewModelProvider(this).get(CryptoListViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        cryptolistRecyclerView.layoutManager = LinearLayoutManager(this)
        cryptolistRecyclerView.adapter = CryptoListAdapter{
            val intent = Intent(this, CryptoInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        viewModel.getCryptoList()

        viewModel.CryptoList.observe(this, Observer { list ->
            (cryptolistRecyclerView.adapter as CryptoListAdapter).setData(list)
        })
    }
}