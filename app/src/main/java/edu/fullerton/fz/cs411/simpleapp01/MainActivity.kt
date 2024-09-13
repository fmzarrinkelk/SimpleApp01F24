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

        manImage = findViewById(R.id.man_with_hat_id)
        manImage.setImageDrawable(getDrawable(R.drawable.man_with_hat))
    }

    private fun updateManImage() {
        val newImageId: Int = if (glassesOn) {
            R.drawable.man_with_glasses
        } else {
            R.drawable.man_with_hat
        }
        this.manImage.setImageResource(newImageId)
    }

    private fun updateCounterView() {
        counterView.text = counter.toString()
    }

}