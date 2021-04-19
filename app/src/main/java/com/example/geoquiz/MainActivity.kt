package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestion()
        setupViews()
    }

    private fun loadQuestion() {

        questions = ArrayList()

        var question = Question("¿Es Perú sólo Lima?", true)
        questions.add(question)

        question = Question("¿Es el Huáscar una maravilla del Mundo?", false)
        questions.add(question)

        question = Question("¿Es Venezuela el país donde esta Caracas?", true)
        questions.add(question)

        question = Question("La capital de Perú es Cuzco?", false)
        questions.add(question)
    }

    private fun setupViews() {

        textView.text = questions[position].sentence
        btYes.setOnClickListener(){
            if(questions[position].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                position++
                if (position == 4) {
                    position = 0
                }
                textView.text = questions[position].sentence
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }

    }
        btNo.setOnClickListener(){
            if(!questions[position].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                position++
                if (position == 4) {
                    position = 0
                }
                textView.text = questions[position].sentence
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }

        }
        btNext.setOnClickListener{
            position++
            if(position == 4){
                position = 0
            }
            textView.text = questions[position].sentence

        }
    }
}