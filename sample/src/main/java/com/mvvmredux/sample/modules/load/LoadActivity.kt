package com.mvvmredux.sample.modules.load

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.mvvmredux.ext.onEvent
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.sample.R
import com.mvvmredux.viewmodel.getViewModel

class LoadActivity : AppCompatActivity(R.layout.activity_load) {

    private val eventViewModel by getViewModel { LoadViewModel(SingleLiveEvent()) }
    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progress_bar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        progressBar.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun setupListener() {
        val loaderButton = findViewById<Button>(R.id.loader_button)
        loaderButton.setOnClickListener {
            if (progressBar.visibility == View.VISIBLE) {
                eventViewModel.hideLoader()
            } else {
                eventViewModel.showLoader()
            }
        }
    }
}