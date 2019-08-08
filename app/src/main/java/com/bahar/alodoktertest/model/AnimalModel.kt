package com.bahar.alodoktertest.model

import java.io.Serializable

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class AnimalModel {
    var animalImage: Int = 0
    var animalDetailModel: ArrayList<AnimalDetailModel> = ArrayList()

    constructor(productImage: Int, productDetailModel: ArrayList<AnimalDetailModel>) {
        this.animalImage = productImage
        this.animalDetailModel = productDetailModel
    }
}