package com.example.quizapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private var total : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submit(view: View) {
        val current = LocalDateTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)
        val message = "Congratulations! You submitted on current $date and $time, Your achieved $total%"
        showResultDialog(message)
    }

    private fun showResultDialog(message: String) {
        let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.ok
                ) { dialog, _ ->
                    total = 0;
                    dialog.dismiss()
                }
            }
            builder.setTitle("QuizApp Result").setMessage(message)
            builder.create()
        }?.show()
    }

    fun reset(view: View) {
        val radio = findViewById<RadioGroup>(R.id.radio)
        radio.clearCheck()

        val q1 = findViewById<CheckBox>(R.id.check_q2_a)
        val q2 = findViewById<CheckBox>(R.id.check_q2_b)
        val q3 = findViewById<CheckBox>(R.id.check_q2_c)
        if(q1.isChecked)
            q1.isChecked = false
        if(q2.isChecked)
            q2.isChecked = false
        if(q3.isChecked)
            q3.isChecked = false

    }

    fun onRadioButtonClicked(view: View){
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_q1_b ->
                    if (checked) {
                        total += 50
                    }
            }
        }
    }

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {

            val c: Boolean = view.isChecked

            when (view.id) {
                R.id.check_q2_a -> {
                    if (c) {
                        total += 25
                    }
                }

                R.id.check_q2_b -> {
                    if (c) {
                        total += 25
                    }
                }
            }

        }
    }

}