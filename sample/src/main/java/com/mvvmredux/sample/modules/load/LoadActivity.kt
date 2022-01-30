package com.mvvmredux.sample.modules.load

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.ext.onEvent
import com.mvvmredux.sample.R
import com.mvvmredux.sample.databinding.ActivityLoadBinding
import com.mvvmredux.viewmodel.getViewModel

class LoadActivity : AppCompatActivity(R.layout.activity_load) {

    private val binding by lazy { ActivityLoadBinding.inflate(layoutInflater) }
    private val eventViewModel by getViewModel { LoadViewModel(SingleLiveEvent()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupEventListener()
        setupListener()
    }

    private fun setupEventListener() {
        onEvent(eventViewModel) { event ->
            when (event) {
                is LoadEvent.ShowLoader -> showLoader(true)
                is LoadEvent.HideLoader -> showLoader(false)
            }
        }
    }

    private fun showLoader(show: Boolean) {
        binding.progressBar.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun setupListener() {
        val loaderButton = findViewById<Button>(R.id.loader_button)
        loaderButton.setOnClickListener {
            if (binding.progressBar.visibility == View.VISIBLE) {
                eventViewModel.hideLoader()
            } else {
                eventViewModel.showLoader()
            }
        }
    }
}