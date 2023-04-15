package com.example.riddles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.riddles.databinding.ActivityAnswersBinding

class ActivityAnswers : AppCompatActivity() {
    private lateinit var binding: ActivityAnswersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Name()
        binding.btnAnswering.setOnClickListener {
            Poisk()
        }
    }
    var namezag = ""
    var RadBtn = listOf("Ландыш","Поезд","Яблоня","Ромашка","Медуза","Белка","Снег","Карта","Ёлка","Береза")
    var RadBtnRand = RadBtn.shuffled()
    fun Name() {
        binding.radioButton1.text = RadBtnRand[0]
        binding.radioButton2.text = RadBtnRand[1]
        binding.radioButton3.text = RadBtnRand[2]
        binding.radioButton4.text = RadBtnRand[3]
        binding.radioButton5.text = RadBtnRand[4]
        binding.radioButton6.text = RadBtnRand[5]
        binding.radioButton7.text = RadBtnRand[6]
        binding.radioButton8.text = RadBtnRand[7]
        binding.radioButton9.text = RadBtnRand[8]
        binding.radioButton10.text = RadBtnRand[9]
    }
    fun Poisk() {
        when (binding.RadioGroup.checkedRadioButtonId) {
            binding.radioButton1.id -> namezag = binding.radioButton1.text.toString()
            binding.radioButton2.id -> namezag = binding.radioButton2.text.toString()
            binding.radioButton3.id -> namezag = binding.radioButton3.text.toString()
            binding.radioButton4.id -> namezag = binding.radioButton4.text.toString()
            binding.radioButton5.id -> namezag = binding.radioButton5.text.toString()
            binding.radioButton6.id -> namezag = binding.radioButton6.text.toString()
            binding.radioButton7.id -> namezag = binding.radioButton7.text.toString()
            binding.radioButton8.id -> namezag = binding.radioButton8.text.toString()
            binding.radioButton9.id -> namezag = binding.radioButton9.text.toString()
            binding.radioButton10.id -> namezag = binding.radioButton10.text.toString()
        }

        if (namezag != "") {
            var idOtv = RadBtn.indexOf(namezag)
            intent.putExtra("put", idOtv.toString())
            intent.putExtra("Rad", namezag)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}


