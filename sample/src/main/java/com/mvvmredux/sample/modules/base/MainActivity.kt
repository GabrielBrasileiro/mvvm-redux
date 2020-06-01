package com.mvvmredux.sample.modules.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvmredux.sample.R
import com.mvvmredux.sample.ext.getViewModel
import com.mvvmredux.sample.modules.state.StateActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by getViewModel { BaseSampleViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
