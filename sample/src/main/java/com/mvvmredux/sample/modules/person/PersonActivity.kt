package com.mvvmredux.sample.modules.person

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.mvvmredux.ext.onStateChanged
import com.mvvmredux.sample.databinding.ActivityPersonBinding
import com.mvvmredux.viewmodel.getViewModel

class PersonActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPersonBinding.inflate(layoutInflater) }
    private val stateViewModel by getViewModel { PersonViewModel(PersonReducer()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupStateListener()
        setupTextListeners()
    }

    private fun setupStateListener() {
        onStateChanged(stateViewModel) { setupTexts(it.name, it.age) }
    }

    private fun setupTexts(name: String, age: String) {
        binding.nameTextView.text = name
        binding.ageTextView.text = age
    }

    private fun setupTextListeners() {
        binding.nameEditText.addTextChangedListener { stateViewModel.saveName(it.toString()) }
        binding.ageEditText.addTextChangedListener { stateViewModel.saveAge(it.toString()) }
    }
}