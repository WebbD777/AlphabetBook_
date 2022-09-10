package com.example.alphabet14

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.FileNotFoundException
import java.lang.NullPointerException

//import sun.net.ext.ExtendedSocketOptions.options


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonA: Button
    private lateinit var buttonB: Button
    private lateinit var buttonC: Button
    private lateinit var buttonD: Button
    private lateinit var buttonE: Button
    private lateinit var buttonF: Button
    private lateinit var buttonG: Button
    private lateinit var buttonH: Button
    private lateinit var buttonI: Button
    private lateinit var buttonJ: Button
    private lateinit var buttonK: Button
    private lateinit var buttonL: Button
    private lateinit var buttonM: Button
    private lateinit var buttonN: Button
    private lateinit var buttonO: Button
    private lateinit var buttonP: Button
    private lateinit var buttonQ: Button
    private lateinit var buttonR: Button
    private lateinit var buttonS: Button
    private lateinit var buttonT: Button
    private lateinit var buttonU: Button
    private lateinit var buttonV: Button
    private lateinit var buttonW: Button
    private lateinit var buttonX: Button
    private lateinit var buttonY: Button
    private lateinit var buttonZ: Button

    private lateinit var resIntArray: IntArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonA =  findViewById(R.id.buttonA)
        buttonB =  findViewById(R.id.buttonB)
        buttonC =  findViewById(R.id.buttonC)
        buttonD =  findViewById(R.id.buttonD)
        buttonE =  findViewById(R.id.buttonE)
        buttonF =  findViewById(R.id.buttonF)
        buttonG =  findViewById(R.id.buttonG)
        buttonH =  findViewById(R.id.buttonH)
        buttonI =  findViewById(R.id.buttonI)
        buttonJ =  findViewById(R.id.buttonJ)
        buttonK =  findViewById(R.id.buttonK)
        buttonL =  findViewById(R.id.buttonL)
        buttonM =  findViewById(R.id.buttonM)
        buttonN =  findViewById(R.id.buttonN)
        buttonO =  findViewById(R.id.buttonO)
        buttonP =  findViewById(R.id.buttonP)
        buttonQ =  findViewById(R.id.buttonQ)
        buttonR =  findViewById(R.id.buttonR)
        buttonS =  findViewById(R.id.buttonS)
        buttonT =  findViewById(R.id.buttonT)
        buttonU =  findViewById(R.id.buttonU)
        buttonV =  findViewById(R.id.buttonV)
        buttonW =  findViewById(R.id.buttonW)
        buttonX =  findViewById(R.id.buttonX)
        buttonY =  findViewById(R.id.buttonY)
        buttonZ =  findViewById(R.id.buttonZ)

        buttonA.setOnClickListener(this)
        buttonB.setOnClickListener(this)
        buttonC.setOnClickListener(this)
        buttonD.setOnClickListener(this)
        buttonE.setOnClickListener(this)
        buttonF.setOnClickListener(this)
        buttonG.setOnClickListener(this)
        buttonH.setOnClickListener(this)
        buttonI.setOnClickListener(this)
        buttonJ.setOnClickListener(this)
        buttonK.setOnClickListener(this)
        buttonL.setOnClickListener(this)
        buttonM.setOnClickListener(this)
        buttonN.setOnClickListener(this)
        buttonO.setOnClickListener(this)
        buttonP.setOnClickListener(this)
        buttonQ.setOnClickListener(this)
        buttonR.setOnClickListener(this)
        buttonS.setOnClickListener(this)
        buttonT.setOnClickListener(this)
        buttonU.setOnClickListener(this)
        buttonV.setOnClickListener(this)
        buttonW.setOnClickListener(this)
        buttonX.setOnClickListener(this)
        buttonY.setOnClickListener(this)
        buttonZ.setOnClickListener(this)

        resIntArray = loopRes()

      //  switchActivity()
    }

    fun switchActivity(){

        buttonA =  findViewById(R.id.buttonA)

        buttonA.setOnClickListener{
            val intent = Intent(this,LetterActivity::class.java)
          //  intent.putExtra("SHOW_WELCOME", true)
            startActivity(intent)
          //  finish()
        }
    }

    // Function to check and request permission.
    private fun checkPermission() {
        // if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }

        // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        //if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)

    }



    override fun onClick(view: View?)
    {
        when ( view!!.id)
        {
            R.id.buttonA->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                  intent.putExtra("letter", resIntArray[0])
                startActivity(intent)
            }
            R.id.buttonB->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[1])
                startActivity(intent)
            }
            R.id.buttonC->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[2])
                startActivity(intent)
            }
            R.id.buttonD->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[3])
                startActivity(intent)
            }
            R.id.buttonA->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[4])
                startActivity(intent)
            }
            R.id.buttonE->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[5])
                startActivity(intent)
            }
            R.id.buttonF->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[6])
                startActivity(intent)
            }
            R.id.buttonG->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[7])
                startActivity(intent)
            }
            R.id.buttonH->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[8])
                startActivity(intent)
            }
            R.id.buttonI->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[9])
                startActivity(intent)
            }
            R.id.buttonJ->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[10])
                startActivity(intent)
            }
            R.id.buttonK->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[11])
                startActivity(intent)
            }
            R.id.buttonL->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[12])
                startActivity(intent)
            }
            R.id.buttonM->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[13])
                startActivity(intent)
            }
            R.id.buttonN->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[14])
                startActivity(intent)
            }
            R.id.buttonO->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[15])
                startActivity(intent)
            }
            R.id.buttonP->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[16])
                startActivity(intent)
            }
            R.id.buttonQ->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[17])
                startActivity(intent)
            }
            R.id.buttonR->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[0])
                startActivity(intent)
            }
            R.id.buttonS->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[18])
                startActivity(intent)
            }
            R.id.buttonT->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[19])
                startActivity(intent)
            }
            R.id.buttonU->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[20])
                startActivity(intent)
            }
            R.id.buttonV->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[21])
                startActivity(intent)
            }
            R.id.buttonW->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[22])
                startActivity(intent)
            }
            R.id.buttonX->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[23])
                startActivity(intent)
            }
            R.id.buttonY->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[24])
                startActivity(intent)
            }
            R.id.buttonZ->
            {
                val intent = Intent(this@MainActivity,LetterActivity::class.java)
                intent.putExtra("letter", resIntArray[25])
                startActivity(intent)
            }
        }

    }

    fun loopRes():IntArray{

        var resArrID = IntArray(26)

        for (i in 1..26){
            if (i < 10) {
                var draw: String = "slide0"+i
                //var draw: String = "drawable/slide0.gif"

                var id:Int = resources.getIdentifier(draw, "drawable", packageName)
                if (i==1){Log.e("Sheldon", id.toString())}
                resArrID[i-1] = id
            }
            else if (i >= 10){
                var draw: String = "slide"+i
                var id:Int = resources.getIdentifier(draw, "drawable", packageName)
                resArrID[i-1] = id
            }

        }
        return resArrID
    }

}