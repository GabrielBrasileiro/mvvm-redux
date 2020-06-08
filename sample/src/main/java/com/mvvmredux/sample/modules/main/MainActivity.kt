package com.mvvmredux.sample.modules.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ext.onEvent
import com.example.ext.onStateChanged
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.sample.R
import com.example.viewmodel.getViewModel
import com.mvvmredux.sample.modules.load.LoadActivity
import com.mvvmredux.sample.modules.person.PersonActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by getViewModel {
        val screenMessage = getString(R.string.base_activity_default_screen_name)
        MainViewModel(screenMessage, SingleLiveEvent(), MainReducer())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        onStateChanged(viewModel) {
            showData(it.screenName)
        }
    }

    private fun setupButtonListeners() {
        val eventButton = findViewById<Button>(R.id.event_sample_button)
        val stateButton = findViewById<Button>(R.id.state_sample_button)

        eventButton.setOnClickListener {
            viewModel.setScreenMessage(getString(R.string.base_activity_event_screen_message))
            viewModel.showPersonScreen()
        }
        stateButton.setOnClickListener {
            viewModel.setScreenMessage(getString(R.string.base_activity_state_screen_message))
            viewModel.showLoadScreen()
        }
    }

    private fun showData(screenName: String) {
        val messageTextView = findViewById<TextView>(R.id.message_text_view)
        messageTextView.text = screenName
    }

    private inline fun <reified A : Activity> startActivity() {
        startActivity(Intent(this, A::class.java))
    }
}
