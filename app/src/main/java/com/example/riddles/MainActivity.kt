package com.example.riddles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.riddles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var trueCounter = 0
    private var falseCounter = 0
    private var allCounter = 0
    private var i=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btnStatistic.setOnClickListener {
                intent = Intent(this, ActivityStatistics::class.java)
                intent.putExtra("trueCount", trueCounter.toString())
                intent.putExtra("falseCount", falseCounter.toString())
                intent.putExtra("allCount", allCounter.toString())
                startActivity(intent)
            }

            binding.btnGetRiddle.setOnClickListener {
                binding.tvAnswer.text = ""
                binding.btnGiveAnswer.isEnabled = true
                binding.btnGetRiddle.isEnabled = false
                ++allCounter
                binding.tvRiddles.text="${Clone[i]}"
                binding.tvAnswer.setBackgroundColor(Color.WHITE)
                i++
                binding.tvRiddlesCounterBase.text = allCounter.toString()
            }

            binding.btnRepeat.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            binding.btnExit.setOnClickListener {
                finish()
            }
            binding.btnGiveAnswer.setOnClickListener {
                intent = Intent(this, ActivityAnswers::class.java)
                startActivityForResult(intent,100)
                binding.btnGiveAnswer.isEnabled = false
                binding.btnGetRiddle.isEnabled = true
            }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100&&resultCode== RESULT_OK&&data!=null) {
            val indexMas= RiddlesArr.indexOf(Clone[i-1])
            if (indexMas.toString()==data.getStringExtra("put")) {
                binding.tvAnswer.setBackgroundColor(Color.GREEN)
                binding.tvAnswer.text=data.getStringExtra("Rad")
                ++trueCounter
            }
            if(indexMas.toString()!=data.getStringExtra("put"))
            {
                binding.tvAnswer.setBackgroundColor(Color.RED)
                binding.tvAnswer.text=data.getStringExtra("Rad")
                ++falseCounter
            }
            if (allCounter == 10) {
                binding.btnStatistic.isVisible = true
                binding.btnGetRiddle.isVisible = false
                binding.btnGiveAnswer.isVisible = false
                binding.btnRepeat.isVisible = true
                binding.btnExit.isVisible = true

            }
        }
    }

    val RiddlesArr = arrayOf(
        "Этот цветок распускается в мае, \n" +
                "Белые бусинки он одевает.",
        "Мчится печка впереди,\n" +
                "Тащит избы позади.",
        "По весне глаз радует,\n " +
                "по осени – язычок.",
        "До чего ж цветок пригож – \n" +
                "Он на солнышко похож.",
        "Зонтик этот ты не тронь –\n" +
                "Обжигает, как огонь. ",
        "Сидит на ветке, а не птица.\n" +
                "Есть рыжый хвост, а не лисица.",
        "На всех садится, никого не боится.",
        "Государства и моря –\n" +
                "Все на стенке у меня.",
        "Дерево-ёж\n" +
                "Носит платье клёш.",
        "Зелена, а не трава;\n" +
                "белена, а не снег;\n" +
                "кудрява, а без волос.")

    val Clone= copyArray(RiddlesArr)
    fun copyArray(source: Array<String>): Array<String?> {
        return source.copyOf(source.size)
    }
}



