package com.example.crypto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.R
import com.example.crypto.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(private  val context:Context):RecyclerView.Adapter<CoinInfoAdapter.CoinViewHolder>() {
    var  coinInfoList:List<CoinPriceInfo> = listOf()
    set(value) {
       field=value
        notifyDataSetChanged()
    }
    var onCoinClickListener:OnCoinClickListener?=null
    inner  class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val ivLogoCoin=itemView.ivLogoCoina
val tvSymbols=itemView.tvSymbols
val tvPrice=itemView.tvPrice
val tvLastUptade=itemView.tvLastUptade

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info,parent,false)
      return  CoinViewHolder(view)

    }

    override fun getItemCount() = coinInfoList.size

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
      val coin= coinInfoList[position]
        with(holder){
            with(coin){
                val symbolsTemplate=context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate=context.resources.getString(R.string.last_update_templete)
                tvSymbols.text= String.format(symbolsTemplate,fROMSYMBOL,tOSYMBOL)

                tvPrice.text= pRICE.toString()
                tvLastUptade.text= String.format(lastUpdateTemplate,getFormatetTime())
                Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
              itemView.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }

        }

    }
    interface OnCoinClickListener{
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}