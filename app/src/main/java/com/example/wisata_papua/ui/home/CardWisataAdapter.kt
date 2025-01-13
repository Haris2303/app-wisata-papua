package com.example.wisata_papua.ui.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_papua.DetailActivity
import com.example.wisata_papua.R

class CardWisataAdapter(private val context: Context, private val dataList: List<ItemDataWisata>):
    RecyclerView.Adapter<CardWisataAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.iv_item_image_wisata)
        val titleTextView: TextView = view.findViewById(R.id.tv_item_title_wisata)
        val subtitleTextView: TextView = view.findViewById(R.id.tv_item_subtitle_wisata)
        val priceTextView: TextView = view.findViewById(R.id.tv_item_price_wisata)
        val detailButton: Button = view.findViewById(R.id.btn_item_detail_wisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_wisata, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.titleTextView.text = item.title
        holder.subtitleTextView.text = item.subtitle
        holder.priceTextView.text = item.price
        holder.detailButton.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("TITLE", item.title)
            context.startActivity(intent)
            Log.i("BUTTON DETAIL", "Tombol detail ditekan!")
        }
    }

    override fun getItemCount() = dataList.size

}