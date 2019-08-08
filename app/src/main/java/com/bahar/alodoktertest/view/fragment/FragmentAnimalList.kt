package com.bahar.alodoktertest.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.callback.IAnimalListCallback
import com.bahar.alodoktertest.databinding.FragmentAnimalListBinding
import com.bahar.alodoktertest.model.AnimalModel
import com.bahar.alodoktertest.view.activity.AnimalDetailsActivity
import com.bahar.alodoktertest.view.activity.HomeActivity
import com.bahar.alodoktertest.view.adapter.AnimalListAdapter
import com.bahar.alodoktertest.viewmodel.AnimalDetailsActivityViewModel
import com.bahar.alodoktertest.viewmodel.AnimalListFragmentViewModel

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class FragmentAnimalList : Fragment() {

    private lateinit var binding: FragmentAnimalListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalListViewModel: AnimalListFragmentViewModel
    private lateinit var animalListAdapter: AnimalListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_animal_list, container, false)

        recyclerView = binding.root.findViewById(R.id.animal_list_rv)

        animalListViewModel = ViewModelProviders.of(activity!!).get(AnimalListFragmentViewModel::class.java)

        animalListViewModel.init()

        initRecycleView()

        animalListViewModel.getAnimalList().observe(activity!!, Observer<List<AnimalModel>> { animalModel ->
            animalListAdapter.notifyDataSetChanged()
        })

        return binding.root
    }

    private fun initRecycleView() {
        animalListAdapter = AnimalListAdapter(animalListViewModel.getAnimalList().value, object : IAnimalListCallback {
            override fun onAnimalClicked(position: Int) {
                //there is many way to do this, this one using intent extra
                //but there is another way like storing to local variable etc
                val intent = Intent(activity, AnimalDetailsActivity::class.java)
                intent.putExtra("animalId", position)
                startActivity(intent)
            }
        })
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = animalListAdapter
    }
}