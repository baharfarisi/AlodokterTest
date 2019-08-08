package com.bahar.alodoktertest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bahar.alodoktertest.model.AnimalModel
import com.bahar.alodoktertest.repository.AnimalRepository

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
class AnimalDetailsActivityViewModel:ViewModel() {
    private var animalDetails: MutableLiveData<AnimalModel>? = MutableLiveData()
    private lateinit var animalRepo: AnimalRepository

    fun init(position:Int) {
        animalRepo = AnimalRepository().getInstance()
        animalDetails!!.value = animalRepo.getAnimalData().value!![position]
    }

    fun getAnimalDetails(): LiveData<AnimalModel> {
        return animalDetails!!
    }
}