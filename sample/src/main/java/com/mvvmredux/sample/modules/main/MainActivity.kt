package com.mvvmredux.sample.modules.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.ext.onEvent
import com.mvvmredux.ext.onStateChanged
import com.mvvmredux.sample.R
import com.mvvmredux.sample.databinding.ActivityMainBinding
import com.mvvmredux.sample.modules.load.LoadActivity
import com.mvvmredux.sample.modules.person.PersonActivity
import com.mvvmredux.viewmodel.getViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by getViewModel {
        val screenMessage = getString(R.string.main_activity_default_screen_name)
        MainViewModel(screenMessage, SingleLiveEvent(), MainReducer())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupEventListener()
        setupStateListener()
        setupButtonListeners()
    }

    private fun setupEventListener() {
        onEvent(viewModel) { event ->
            when (event) {
                is MainEvent.ShowLoadScreen -> startActivity<PersonActivity>()
                is MainEvent.ShowPersonScreen -> startActivity<LoadActivity>()
            }
        }
    }

    private fun setupStateListener() {
        onStateChanged(viewModel) { showData(it.screenName) }
    }

    private fun setupButtonListeners() {
        binding.eventSampleButton.setOnClickListener {
            viewModel.setScreenMessage(getString(R.string.main_activity_event_screen_message))
            viewModel.showPersonScreen()
        }
        binding.stateSampleButton.setOnClickListener {
            viewModel.setScreenMessage(getString(R.string.main_activity_state_screen_message))
            viewModel.showLoadScreen()
        }
    }

    private fun showData(screenName: String) {
        binding.messageTextView.text = screenName
    }

    private inline fun <reified A : Activity> startActivity() {
        startActivity(Intent(this, A::class.java))
    }
}
