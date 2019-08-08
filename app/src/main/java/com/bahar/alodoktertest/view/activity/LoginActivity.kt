package com.bahar.alodoktertest.view.activity

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bahar.alodoktertest.R
import com.bahar.alodoktertest.cache.SharedPrefManager
import com.bahar.alodoktertest.databinding.ActivityLoginBinding
import com.bahar.alodoktertest.viewmodel.LoginActivityViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefManager: SharedPrefManager
    private lateinit var loginViewModel: LoginActivityViewModel
    private var activity: Activity = this@LoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)
        prefManager = SharedPrefManager(this)

        binding.activityLoginLoginBtn.setOnClickListener {
            val email = binding.activityLoginEmailEt.text.toString()
            val password = binding.activityLoginPasswordEt.text.toString()

            loginViewModel.validateCredentials(email, password).observe(this,
                Observer<String> { t ->
                    Toast.makeText(activity, t, Toast.LENGTH_LONG).show()

                    if (t.equals("Login Successful")) {
                        prefManager.setLoginStatus(true)
                        goToMainActivity()
                    }
                })
        }

        if (prefManager.getLoginStatus()) {
            goToMainActivity()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
