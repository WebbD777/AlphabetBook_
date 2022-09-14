package com.example.alphabet14

/* Name: Dylan Webb
   Student Number: WBBDYL001
   Assignment: MDD1
* */

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LetterActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var buttonA: Button
    private lateinit var buttonZ: Button
    private lateinit var buttonOver: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button

    private lateinit var imageView:ImageView

    var presenter = Presenter()



    override fun onClick(view: View?) {
        /*Method detects button pressed and gives info to Presenter class to handle
        * */
        var sp: SharedPreferences = getSharedPreferences("myActivity", Context.MODE_PRIVATE)
        var spEdit: SharedPreferences.Editor = sp.edit()

        when (view!!.id) {

            R.id.buttonA -> {
                spEdit.putInt("letter", 0)
                spEdit.commit()

                presenter.setImageIn(0)
                presenter.setLetterImageView(imageView)

            }
            R.id.buttonZ -> {
                spEdit.putInt("letter", 25)
                spEdit.commit()

                presenter.setImageIn(25)
                presenter.setLetterImageView(imageView)
            }
            R.id.buttonOver -> {
                val intent = Intent(this@LetterActivity,OverviewActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.buttonNext -> {

                if (Model.getIndex()!=25){
                    presenter.setImageIn(Model.getIndex()+1)
                    spEdit.putInt("letter", Model.getIndex()+1)
                    spEdit.commit()

                    presenter.setLetterImageView(imageView)
                }
                else{
                    presenter.setImageIn(0)
                    spEdit.putInt("letter", 0)
                    spEdit.commit()

                    presenter.setLetterImageView(imageView)
                }
            }
            R.id.buttonPrevious -> {

                if (Model.getIndex()!=0){
                    spEdit.putInt("letter", Model.getIndex()-1)
                    spEdit.commit()

                    presenter.setImageIn(Model.getIndex()-1)
                    presenter.setLetterImageView(imageView)
                }
                else{
                    spEdit.putInt("letter", 25)
                    spEdit.commit()

                    presenter.setImageIn(25)
                    presenter.setLetterImageView(imageView)
                }
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        var sp: SharedPreferences = getSharedPreferences("myActivity", Context.MODE_PRIVATE)
        var spEdit: SharedPreferences.Editor = sp.edit()

        spEdit.putString("activity", "LetterActivity")
        spEdit.commit()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        imageView = findViewById(R.id.slideA)

        createButton()

        presenter.setLetterImageView(imageView)

    }


    fun createButton(){
        buttonA =  findViewById(R.id.buttonA)
        buttonZ =  findViewById(R.id.buttonZ)
        buttonOver =  findViewById(R.id.buttonOver)
        buttonNext =  findViewById(R.id.buttonNext)
        buttonPrevious =  findViewById(R.id.buttonPrevious)

        buttonA.setOnClickListener(this)
        buttonZ.setOnClickListener(this)
        buttonOver.setOnClickListener(this)
        buttonNext.setOnClickListener(this)
        buttonPrevious.setOnClickListener(this)
    }
}