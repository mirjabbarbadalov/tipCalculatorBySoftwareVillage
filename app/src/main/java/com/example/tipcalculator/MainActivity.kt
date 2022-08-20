package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lastTip = 0.0;
        var answer = 0.0
        var money = 0.0;
        var percentage = 0.0;

        binding.buttonCalculate.setOnClickListener {


            if (binding.moneyInput.text.toString().isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Money place must be filled! ",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            } else {
                money = binding.moneyInput.text.toString().toDouble();
            }



            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.percentage20 -> percentage= 0.2
                R.id.percentage15 -> percentage= 0.15
                else -> percentage= 0.08
            }

            answer = money * percentage;



        if(binding.switchCheck.isChecked){
           lastTip =ceil(answer)
        }
        else{
            lastTip = answer;
        }

            binding.tipOutput.text = lastTip.toString()

        }

    }
   override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}





