package com.mvvmredux.sample.modules.person

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.mvvmredux.ext.onStateChanged
import com.mvvmredux.sample.R
import com.mvvmredux.viewmodel.getViewModel

class PersonActivity : AppCompatActivity(R.layout.activity_person) {

    private val stateViewModel by getViewModel { PersonViewModel(PersonReducer()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupStateListener()
        setupTextListeners()
    }

    private fun setupStateListener() {
        onStateChanged(stateViewModel) { setupTexts(it.name, it.age) }
    }

    private fun setupTexts(name: String, age: String) {
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        val ageTextView = findViewById<TextView>(R.id.age_text_view)

        nameTextView.text = name
        ageTextView.text = age
    }

    private fun setupTextListeners() {
        val nameEditText = findViewById<EditText>(R.id.name_edit_text)
        val ageEditText = findViewById<EditText>(R.id.age_edit_text)

        nameEditText.addTextChangedListener { stateViewModel.saveName(it.toString()) }
        ageEditText.addTextChangedListener { stateViewModel.saveAge(it.toString()) }
    }
}