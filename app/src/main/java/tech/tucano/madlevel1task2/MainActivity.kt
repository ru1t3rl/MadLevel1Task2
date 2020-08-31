package tech.tucano.madlevel1task2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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
        /*
        setOnFocusChangeListener(binding.inputRow1)
        setOnFocusChangeListener(binding.inputRow2)
        setOnFocusChangeListener(binding.inputRow3)
        setOnFocusChangeListener(binding.inputRow4)
        */

        setOnTextChangedListener(binding.inputRow1)
        setOnTextChangedListener(binding.inputRow2)
        setOnTextChangedListener(binding.inputRow3)
        setOnTextChangedListener(binding.inputRow4)

        binding.btnSubmit.setOnClickListener { OnSubmitClick() }
    }

    private fun OnSubmitClick(){
        if(inputRow1.text[0].toLowerCase() == 't' &&
                inputRow2.text[0].toLowerCase() == 'f' &&
                inputRow3.text[0].toLowerCase() == 'f' &&
                inputRow4.text[0].toLowerCase() == 'f')
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

    /**
     * Adds an on text changed listener
     * When the text has changed, check the fields for answers
     */
    private fun setOnTextChangedListener(editText: EditText){
        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, aft: Int) {}
            override fun afterTextChanged(s: Editable) {
                checkFields()
            }
        })
    }

    /**
     * Adds an on focus changed listener
     * When the text has changed, check the fields for answers
     */
    private fun setOnFocusChangeListener(textView: TextView) {
        textView.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                checkFields()
            }
        }
    }

    private fun checkFields() {
            binding.btnSubmit.isEnabled =
                    !binding.inputRow1.text.isNullOrBlank() &&
                    !binding.inputRow2.text.isNullOrBlank() &&
                    !binding.inputRow3.text.isNullOrBlank() &&
                    !binding.inputRow4.text.isNullOrBlank()

    }
}