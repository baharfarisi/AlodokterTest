package com.bahar.alodoktertest.repository

import android.arch.lifecycle.MutableLiveData
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.model.AnimalDetailModel
import com.bahar.alodoktertest.model.AnimalModel

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class AnimalRepository {
    // repository data that you can get from webservices or sql

    private var instance: AnimalRepository? = null
    private var dataSet: ArrayList<AnimalModel> = ArrayList()

    public fun getInstance(): AnimalRepository {
        if (instance == null) {
            instance = AnimalRepository()
        }
        return instance as AnimalRepository
    }

    public fun getAnimalData(): MutableLiveData<List<AnimalModel>> {
        setAnimalData()

        val data: MutableLiveData<List<AnimalModel>> = MutableLiveData()
        data.value = dataSet

        return data
    }

    private fun setAnimalData() {
        val porcupineList: ArrayList<AnimalDetailModel> = ArrayList()
        porcupineList.add(AnimalDetailModel(R.drawable.porcupine_1))
        porcupineList.add(AnimalDetailModel(R.drawable.porcupine_2))
        porcupineList.add(AnimalDetailModel(R.drawable.porcupine_3))

        val horseSeaList: ArrayList<AnimalDetailModel> = ArrayList()
        horseSeaList.add(AnimalDetailModel(R.drawable.horsesea_1))
        horseSeaList.add(AnimalDetailModel(R.drawable.horsesea_2))
        horseSeaList.add(AnimalDetailModel(R.drawable.horsesea_3))
        horseSeaList.add(AnimalDetailModel(R.drawable.horsesea_4))

        val swanList: ArrayList<AnimalDetailModel> = ArrayList()
        swanList.add(AnimalDetailModel(R.drawable.swan_1))
        swanList.add(AnimalDetailModel(R.drawable.swan_2))
        swanList.add(AnimalDetailModel(R.drawable.swan_3))

        dataSet.add(AnimalModel(R.drawable.porcupine_1, porcupineList))
        dataSet.add(AnimalModel(R.drawable.horsesea_1, horseSeaList))
        dataSet.add(AnimalModel(R.drawable.swan_1, swanList))
    }
}