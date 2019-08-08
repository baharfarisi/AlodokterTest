package com.bahar.alodoktertest.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.databinding.ActivityAnimalDetailsBinding
import com.bahar.alodoktertest.model.AnimalDetailModel
import com.bahar.alodoktertest.model.AnimalModel
import com.bahar.alodoktertest.view.adapter.SliderAdapter
import com.bahar.alodoktertest.viewmodel.AnimalDetailsActivityViewModel
import com.bahar.alodoktertest.viewmodel.AnimalListFragmentViewModel
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
class AnimalDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailsBinding
    private lateinit var animalDetailViewModel: AnimalDetailsActivityViewModel
    private lateinit var sliderView: SliderView
    private lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animal_details)

        sliderView = findViewById(R.id.animal_slider_sv)

        animalDetailViewModel = ViewModelProviders.of(this).get(AnimalDetailsActivityViewModel::class.java)

        animalDetailViewModel.init(intent.getIntExtra("animalId", 0))

        animalDetailViewModel.getAnimalDetails().observe(this, Observer<AnimalModel> { animalDetail ->
            sliderAdapter.notifyDataSetChanged()
        })

        iniSlider()
    }

    private fun iniSlider() {
        sliderAdapter = SliderAdapter(animalDetailViewModel.getAnimalDetails().value!!.animalDetailModel)

        sliderView.sliderAdapter = sliderAdapter
        binding.animalSliderSv.setIndicatorAnimation(IndicatorAnimations.SLIDE) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.animalSliderSv.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION)
        binding.animalSliderSv.indicatorSelectedColor = Color.WHITE
        binding.animalSliderSv.indicatorUnselectedColor = Color.GRAY
        binding.animalSliderSv.startAutoCycle()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}