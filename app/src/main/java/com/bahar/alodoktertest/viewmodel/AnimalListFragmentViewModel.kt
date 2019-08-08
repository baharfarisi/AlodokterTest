package com.bahar.alodoktertest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bahar.alodoktertest.model.AnimalModel
import com.bahar.alodoktertest.repository.AnimalRepository

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
class AnimalListFragmentViewModel : ViewModel() {
    private var animalList: MutableLiveData<List<AnimalModel>>? = MutableLiveData()
    private lateinit var animalRepo: AnimalRepository

    fun init() {
        animalRepo = AnimalRepository().getInstance()
        animalList = animalRepo.getAnimalData()
    }

    fun getAnimalList(): LiveData<List<AnimalModel>> {
        return animalList!!
    }
}