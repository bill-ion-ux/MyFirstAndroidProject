package com.example.myfirstandroidproject

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CheckResult
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.week5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.FeedbackLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val RateBarFeedback = findViewById<RatingBar>(R.id.RateBarFeedback)
        val TVRating = findViewById<TextView>(R.id.TVRating)
        val ETFeedback = findViewById<TextInputLayout>(R.id.ETFeedback)
        val BtnFeedback = findViewById<Button>(R.id.BtnFeedback)
        val ratedString = getString(R.string.you_have_rated)

        BtnFeedback.setOnClickListener{
            val message = "Thank you for your feedback!"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        RateBarFeedback.setOnRatingBarChangeListener {ratingBar, rating, fromUser ->
            TVRating.text = ratedString + " " +  rating.toString()


        }



    }
    //Question 1
//    fun calculateResult() {
//        val num1 = findViewById<EditText>(R.id.ETnum1)
//        val num2 = findViewById<EditText>(R.id.ETnum2)
//
//        val num1Text = num1.text.toString()
//        val num2Text = num2.text.toString()
//
//        val resultText = if (num1Text.isNotEmpty() && num2Text.isNotEmpty()) {
//            (num1Text.toInt() + num2Text.toInt()).toString()
//        } else {
//            "0"
//        }
//        findViewById<TextView>(R.id.ETResult).text = resultText
//
//    }
//    //Question 2
//    fun btnSubmitOnClick(view: View){
//        val redbox = findViewById<CheckBox>(R.id.redBox)
//        val greenbox = findViewById<CheckBox>(R.id.greenBox)
//        val bluebox = findViewById<CheckBox>(R.id.blueBox)
//
//        val CSLayout = findViewById<ConstraintLayout>(R.id.main1)
//
//
//        if(redbox.isChecked){
//            CSLayout.setBackgroundColor(Color.RED)
//        }else if(greenbox.isChecked) {
//            CSLayout.setBackgroundColor(Color.GREEN)
//        }else if(bluebox.isChecked){
//            CSLayout.setBackgroundColor(Color.BLUE)
//        }else{
//            CSLayout.setBackgroundColor(Color.WHITE)
//        }
//    }

}