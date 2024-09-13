package edu.fullerton.fz.cs411.simpleapp01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var decreaseButton: Button
    private lateinit var increaseButton: Button
    private lateinit var counterView: TextView
    private lateinit var manImage: ImageView
    private lateinit var toggleGlassesButton: Button
    private lateinit var errorButton: Button

    private var glassesOn = false
    private var counter = -99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.decreaseButton = this.findViewById(R.id.decrease_button)
        increaseButton = findViewById(R.id.increase_button)
        counterView = findViewById(R.id.counter)

        counter = counterView.text.toString().toInt()
        updateCounterView()

        decreaseButton.setOnClickListener( { view: View ->
            println("decrease button clicked")
            counter -= 1
            updateCounterView()
        } )

        increaseButton.setOnClickListener {
            val button = it as Button
            val textOfButton = button.text
            println("$textOfButton button clicked")
            counter -= 1
            updateCounterView()
        }

        toggleGlassesButton = findViewById(R.id.toggle_glasses)
        toggleGlassesButton.setOnClickListener {
            this.glassesOn = !this.glassesOn
            this.updateManImage()
        }
        manImage = findViewById(R.id.man_image)
        manImage.setImageDrawable(getDrawable(R.drawable.man_without_glasses))

        errorButton = findViewById(R.id.error_button)
        errorButton.setOnClickListener {
            x()
        }
    }

    private fun updateCounterView() {
        counterView.text = counter.toString()
    }

    private fun updateManImage() {
        val newImageId: Int = if (glassesOn) {
            R.drawable.man_with_glasses
        } else {
            R.drawable.man_without_glasses
        }
        this.manImage.setImageResource(newImageId)
    }


    private fun x() {
        var x1 = 1
        y()
        z(30)
        a()
    }

    private class myException: Exception() {

    }

    private fun a() {
//        val errorButton2: Button = findViewById(R.id.main)
        var a1 = 5
        var a2 = 10
        for (n in 0..a1) {
            val nn = n * 10
            println("$nn")
            for (m in 0..a2) {
                println("the value of m is ${m}")
            }
            try {
                try {
                    val p: Int = 3
                    throw Exception()
                } catch (e1: Exception) {
                    println("exception")
                }
                try {
//                    h()
                    lateinit var b: Button
//                    b.setOnClickListener {}
                    throw CharacterCodingException()
                } catch (e2: CharacterCodingException) {
                    println("$e2")
                }
                throw myException()
            } catch (e: myException) {
                println("Exception $e happened")
            }
        }
    }

    private fun h() {
        throw Exception()
    }

    private fun z(p: Int): String {
        var z1 = 2
        println("I am in z and the value of my variable is ${z1 + p}")
        return "done"
    }

    private fun y() {
        println("I am in y")
        val f = z(20)
        println(f)
    }


}