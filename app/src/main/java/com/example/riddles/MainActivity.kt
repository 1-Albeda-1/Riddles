package com.example.riddles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.riddles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var riddles2 = 0
    var riddles3 = mutableListOf<Int>()
    private var launcher: ActivityResultLauncher<Intent>? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var answerConst = ""
        var trueCounter = 0
        var falseCounter = 0
        var allCounter = 0
        binding.btnStatistic.setOnClickListener{
            val intent = Intent(this, ActivityStatistics::class.java)
            intent.putExtra("trueCount", trueCounter.toString())
            intent.putExtra("falseCount", falseCounter.toString())
            intent.putExtra("allCount", allCounter.toString())
            startActivity(intent)
        }

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
                if (result.resultCode == RESULT_OK){
                    val answerFromUser = result.data?.getStringExtra("answer")
                    binding.tvAnswer.text = "$answerFromUser"
                    binding.btnGetRiddle.isEnabled = true
                    if (answerFromUser == answerConst)
                    {
                        binding.tvAnswer.setBackgroundColor(Color.GREEN)
                        ++trueCounter
                    }
                    else {
                        binding.tvAnswer.setBackgroundColor(Color.RED)
                        ++falseCounter
                    }
                    if (allCounter == 10)
                    {
                        binding.btnStatistic.isVisible = true
                        binding.btnGetRiddle.isVisible = false
                        binding.btnGiveAnswer.isVisible = false
                        binding.btnRepeat.isVisible = true
                        binding.btnExit.isVisible = true

                    }
                }
            }

        binding.btnGetRiddle.setOnClickListener{
            binding.tvAnswer.text=""
            binding.btnGiveAnswer.isEnabled = true
            binding.btnGetRiddle.isEnabled = false
            ++allCounter
            binding.tvRiddlesCounterBase.text = allCounter.toString()

            binding.btnRepeat.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            binding.btnExit.setOnClickListener{
                finish()
            }

            while (true)
            {
                riddles2 = (1..10).random()
                if (riddles2 !in riddles3)
                {
                    riddles3.add(riddles2)
                    break
                }
            }

            when (riddles2){
                1 -> {binding.tvRiddles.text = "Этот цветок распускается в мае, \n" +
                        "Белые бусинки он одевает."
                    answerConst = "Ландыш"
                }
                2-> {
                    binding.tvRiddles.text =  "Мчится печка впереди,\n"+
                            "Тащит избы позади."
                    answerConst = "Поезд"
                }
                3-> {binding.tvRiddles.text = "По весне глаз радует,\n " +
                        "по осени – язычок."
                    answerConst = "Яблоня"}
                4-> {binding.tvRiddles.text = "До чего ж цветок пригож – \n" +
                        "Он на солнышко похож."
                    answerConst = "Ромашка"
                }
                5-> {
                    binding.tvRiddles.text = "Зонтик этот ты не тронь –\n" +
                            "Обжигает, как огонь. "
                    answerConst="Медуза"
                }
                6-> {
                    binding.tvRiddles.text = "Сидит на ветке, а не птица.\n" +
                            "Есть рыжый хвост, а не лисица."
                    answerConst = "Белка"
                }
                7-> {
                    binding.tvRiddles.text = "На всех садится, никого не боится."
                    answerConst = "Cнег"
                }
                8-> {
                    binding.tvRiddles.text = "Государства и моря –\n" +
                            "Все на стенке у меня."
                    answerConst = "Карта"
                }
                9-> {
                    binding.tvRiddles.text = "Дерево-ёж\n" +
                            "Носит платье клёш."
                    answerConst = "Ёлка"
                }
                10-> {
                    binding.tvRiddles.text = "Зелена, а не трава;\n" +
                            "белена, а не снег;\n" +
                            "кудрява, а без волос."
                    answerConst = "Береза"
                }
            }
        }
        binding.btnGiveAnswer.setOnClickListener{
            val intent = Intent(this, ActivityAnswers::class.java)
            launcher?.launch(intent)
            binding.btnGiveAnswer.isEnabled = false
        }
    }
}