package com.example.apptrial

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import android.content.Intent


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openButton = findViewById<Button>(R.id.openButton)
        openButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val myButton = findViewById<Button>(R.id.myButton)
        val displayTextView = findViewById<TextView>(R.id.display) // Use the correct ID here

        myButton.setOnClickListener {
            // Display text in the TextView when the button is clicked
            displayTextView.text = "Hello There!"
        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        val customItems = listOf("Strawberry", "Orange", "Banana", "Pear")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, customItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val colorChangeButton = findViewById<Button>(R.id.changeColorButton)
        val mainLayout = findViewById<ConstraintLayout>(R.id.mainLayout)

        val colors = listOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4/* Add more colors here */)
        var currentColorIndex = 0

        mainLayout.setBackgroundResource(colors[currentColorIndex])

        colorChangeButton.setOnClickListener {
            // Increment the current color index and handle wrapping around to the first color
            currentColorIndex = (currentColorIndex + 1) % colors.size

            // Get the new color from the list based on the current index
            val newColor = ContextCompat.getColor(this, colors[currentColorIndex])

            // Set the new background color
            mainLayout.setBackgroundColor(newColor)
        }


    }
}