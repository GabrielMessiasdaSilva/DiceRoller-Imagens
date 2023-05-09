package com.example.diceroller
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }



    }

    @SuppressLint("SetTextI18n", "WrongViewCast")
    private fun rollDice() {



        val dice = Dice(6)
        val diceRoll = dice.roll();
        val diceImage: ImageView = findViewById(R.id.roll_image)
        diceImage.setImageResource(R.drawable.dice_2)


        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()


        @SuppressLint("WrongViewCast")
        var number: TextView = findViewById(R.id.edtnumberText)




        if (diceRoll == number.text.toString().toInt()) {
            Toast.makeText(this, "Você Ganhou",
                Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Você perdeu",
                Toast.LENGTH_SHORT).show()
        }
    }
}

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
