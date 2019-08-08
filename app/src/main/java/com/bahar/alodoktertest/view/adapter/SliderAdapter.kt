package com.bahar.alodoktertest.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.model.AnimalDetailModel
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
class SliderAdapter(private val animalDetail: List<AnimalDetailModel>) : SliderViewAdapter<SliderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val inflate = LayoutInflater.from(parent!!.context).inflate(R.layout.item_animal_slider, null)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder!!.bindData(animalDetail[position], position)
    }

    override fun getCount(): Int {
        return animalDetail.size
    }

    inner class ViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageViewBackground: ImageView

        init {
            imageViewBackground = itemView.findViewById(R.id.image_slider_iv)
        }

        fun bindData(model: AnimalDetailModel, position: Int) {
            imageViewBackground.setImageResource(model.animalDetailPicture)
        }
    }
}