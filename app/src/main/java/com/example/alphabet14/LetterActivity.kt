package com.example.alphabet14

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import kotlin.properties.Delegates

class LetterActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var buttonA: Button
    private lateinit var buttonZ: Button
    private lateinit var buttonOver: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button

    private lateinit var resArr1: IntArray
    private var resInt1 :Int = 0

    private lateinit var imageView:ImageView

    var presenter = Presenter()

    override fun onClick(view: View?) {
        when (view!!.id) {

            R.id.buttonA -> {
                //resInt1=0
                presenter.setImageIn(0)
                presenter.setImageLetter(imageView, applicationContext)
              //  var bm = BitmapFactory.decodeResource(resources, resArr1?.get(resInt1) ?:0 )
              //  imageView.setImageBitmap(bm)

            }
            R.id.buttonZ -> {
              //  resInt1=25
              //  var bm = BitmapFactory.decodeResource(resources, resArr1?.get(resInt1) ?:0 )
              //  imageView.setImageBitmap(bm)
                presenter.setImageIn(25)
                presenter.setImageLetter(imageView, applicationContext)
            }
            R.id.buttonOver -> {
                val intent = Intent(this@LetterActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.buttonNext -> {
               /* if (resInt1 != 25) {
                    resInt1++
                    var bm = BitmapFactory.decodeResource(resources, resArr1?.get(resInt1) ?: 0)
                    imageView.setImageBitmap(bm)
                }*/

                if (Model.getIndex()!=25){
                    presenter.setImageIn(Model.getIndex()+1)
                    presenter.setImageLetter(imageView, applicationContext)
                }
                else{
                    presenter.setImageIn(0)
                    presenter.setImageLetter(imageView, applicationContext)
                }
            }
            R.id.buttonPrevious -> {
                /*if (resInt1 != 0) {
                    resInt1--
                    var bm = BitmapFactory.decodeResource(resources, resArr1?.get(resInt1) ?: 0)
                    imageView.setImageBitmap(bm)
                }
                else{
                    resInt1=25
                    var bm = BitmapFactory.decodeResource(resources, resArr1?.get(resInt1) ?: 0)
                    imageView.setImageBitmap(bm)
                }*/
                if (Model.getIndex()!=0){
                    presenter.setImageIn(Model.getIndex()-1)
                    presenter.setImageLetter(imageView, applicationContext)
                }
                else{
                    presenter.setImageIn(25)
                    presenter.setImageLetter(imageView, applicationContext)
                }
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)
       // val resInt = intent.getIntExtra("letter", 0)
       // var resArr = intent.getIntArrayExtra("array")
     //   resArr1 = intent.getIntArrayExtra("array")!!

      //  var resInt = intent.getIntExtra("index", 0)
      //  resInt1 = intent.getIntExtra("index", 0)

        imageView = findViewById(R.id.slideA)

        createButton()

       // Log.e("Djake", resInt.toString())


        //val imageView: ImageView = findViewById(resInt)
        var bm = BitmapFactory.decodeResource(resources, Model.getArr().get(Model.getIndex()) ?:0 )
        imageView.setImageBitmap(bm)
        //val imageView: ImageView = findViewById(resInt)
        //DisplayLetter(imageView)

    }

    fun DisplayLetter(imageView: ImageView){

       // val bMap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
       // imageView.setImageBitmap(bMap)

     //  val uri:Uri= Uri.fromFile(File(""))
       // imageView.setImageURI(uri)

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