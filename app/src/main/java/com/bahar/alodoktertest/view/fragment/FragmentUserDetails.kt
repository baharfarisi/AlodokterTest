package com.bahar.alodoktertest.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.databinding.FragmentUserDetailsBinding
import com.bahar.alodoktertest.model.UserModel
import com.bahar.alodoktertest.viewmodel.UserDetailsFragmentViewModel

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class FragmentUserDetails : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding

    private lateinit var userDetailsViewModel: UserDetailsFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details, container, false)

        userDetailsViewModel = ViewModelProviders.of(activity!!).get(UserDetailsFragmentViewModel::class.java)

        userDetailsViewModel.init()

        userDetailsViewModel.getUserDetails().observe(this,
            Observer<UserModel> { userList -> binding.user = userList })

        return binding.root
    }
}