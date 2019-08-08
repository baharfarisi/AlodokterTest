package com.bahar.alodoktertest.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.databinding.ActivityHomeBinding
import com.bahar.alodoktertest.view.fragment.FragmentAnimalList
import com.bahar.alodoktertest.view.fragment.FragmentUserDetails
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Bacharudin A.F on 08/07/19.
 */
class HomeActivity : AppCompatActivity() {

    lateinit var toolBar: ActionBar

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        switchFragment(FragmentAnimalList())

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.home -> {
                        switchFragment(FragmentAnimalList())
                        return true
                    }
                    R.id.user -> {
                        switchFragment(FragmentUserDetails())
                        return true
                    }
                }
                return false
            }

        })
    }

    private fun switchFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }
}