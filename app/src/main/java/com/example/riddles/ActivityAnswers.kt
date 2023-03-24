package com.example.riddles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.riddles.databinding.ActivityAnswersBinding

class ActivityAnswers : AppCompatActivity() {
    private lateinit var binding: ActivityAnswersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioButton1.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton1.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton2.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton2.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton3.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton3.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton4.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton4.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton5.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton5.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton6.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton6.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton7.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton7.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton8.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton8.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton9.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton9.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.radioButton10.setOnClickListener{
            binding.btnAnswering.isEnabled=true
            intent.putExtra("answer", binding.radioButton10.text.toString())
            setResult(RESULT_OK,intent)
        }
        binding.btnAnswering.setOnClickListener{
            finish()
        }
    }
}