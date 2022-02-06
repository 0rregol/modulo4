package com.example.investcenter.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsodelcid.investcenter.R
import com.alonsodelcid.investcenter.model.PokeResult
import kotlinx.android.synthetic.main.card_Crypto_search.view.*

class CryptoListAdapter (val cryptoClick: (Int) -> Unit): RecyclerView.Adapter<CryptoListAdapter.SearchViewHolder>() {
    var cryptomonList: List<CryptoResult> = emptyList<CryptoResult>()

    fun setData(list: List<CryptoResult>){
        CryptoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_crypto_search, parent,false))
    }

    override fun getItemCount(): Int {
        return cryptonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = cryptoList[position]
        holder.itemView.cryptoText.text = "#${position + 1} - ${crypto.name}"

        holder.itemView.setOnClickListener { cryptoClick(position + 1) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
