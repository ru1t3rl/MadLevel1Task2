package tech.tucano.madlevel1task2

import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import tech.tucano.madlevel1task2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isFocused: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFieldnBtns()
    }

    private fun initFieldnBtns(){
        setOnFocusChangeListener(binding.inputRow1)
        setOnFocusChangeListener(binding.inputRow2)
        setOnFocusChangeListener(binding.inputRow3)
        setOnFocusChangeListener(binding.inputRow4)
    }

    private fun setOnFocusChangeListener(text: EditText) {
        text.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                checkFields()
            }
        }
    }

    private fun checkFields() {
            binding.button.isEnabled =
                    !binding.inputRow1.text.isNullOrBlank() &&
                    !binding.inputRow2.text.isNullOrBlank() &&
                    !binding.inputRow3.text.isNullOrBlank() &&
                    !binding.inputRow4.text.isNullOrBlank()

    }
}