package com.bahar.alodoktertest.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.callback.IAnimalListCallback
import com.bahar.alodoktertest.model.AnimalModel

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
class AnimalListAdapter(private val animalModel: List<AnimalModel>?, private val callback: IAnimalListCallback) :
    RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(animalModel!![position], position)
    }

    override fun getItemCount(): Int {
        return animalModel!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var animalPhoto: ImageView

        init {
            animalPhoto = itemView.findViewById(R.id.animal_picture_iv) as ImageView
        }

        fun bindData(model: AnimalModel, position: Int) {
            animalPhoto.setImageResource(model.animalImage)
            animalPhoto.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View) {
                    callback.onAnimalClicked(position)
                }
            })
        }
    }
}