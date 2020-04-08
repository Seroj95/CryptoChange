package com.example.crypto

//import kotlinx.android.synthetic.main.activity_coin_detail.tvPrice
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this, Observer {

            tvPrice.text = """${it.pRICE.toString()} $"""
            tvMinPrice.text = "${it.lOWDAY.toString()} $"
            tvMaxPrice.text = "${it.hIGHDAY.toString()} $"
            tvMArket.text=it.lASTMARKET
            tvUbdate.text=it.getFormatetTime()
            froomSymbol.text=it.fROMSYMBOL
           tvToSymbols.text=it.tOSYMBOL
            Picasso.get().load(it.getFullImageUrl()).into(imageViewLogo)
        })
    }

    //
    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}
