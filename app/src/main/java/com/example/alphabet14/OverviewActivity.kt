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
import androidx.appcompat.app.AppCompatActivity

class OverviewActivity : AppCompatActivity(), View.OnClickListener {

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


    var presenter = Presenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        var t1L = loopResIds1(applicationContext)
        t1L.start()
        presenter.getLoopThread(t1L)
        var sp: SharedPreferences = getSharedPreferences("myActivity", Context.MODE_PRIVATE)
        var spEdit: SharedPreferences.Editor = sp.edit()

        spEdit.putString("activity", "OverviewActivity")
        spEdit.commit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCreate()
    }


    override fun onClick(view: View?)
    {
        var sp: SharedPreferences = getSharedPreferences("myActivity", Context.MODE_PRIVATE)
        var spEdit: SharedPreferences.Editor = sp.edit()

        presenter.setImageArr(applicationContext)

        when ( view!!.id)
        {
            R.id.buttonA->
            {
                spEdit.putInt("letter", 0)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)
                presenter.setImageIn(0)
                startActivity(intent)
                finish()
            }
            R.id.buttonB->
            {
                spEdit.putInt("letter", 1)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)
                presenter.setImageIn(1)
                startActivity(intent)
                finish()
            }
            R.id.buttonC->
            {
                spEdit.putInt("letter", 2)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(2)
                startActivity(intent)
                finish()
            }
            R.id.buttonD->
            {
                spEdit.putInt("letter", 3)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(3)
                startActivity(intent)
                finish()
            }
            R.id.buttonE->
            {
                spEdit.putInt("letter", 4)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(4)
                startActivity(intent)
                finish()
            }
            R.id.buttonF->
            {
                spEdit.putInt("letter", 5)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(5)
                startActivity(intent)
                finish()
            }
            R.id.buttonG->
            {
                spEdit.putInt("letter", 6)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(6)
                startActivity(intent)
                finish()
            }
            R.id.buttonH->
            {
                spEdit.putInt("letter", 7)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(7)
                startActivity(intent)
                finish()
            }
            R.id.buttonI->
            {
                spEdit.putInt("letter", 8)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(8)
                startActivity(intent)
                finish()
            }
            R.id.buttonJ->
            {
                spEdit.putInt("letter", 9)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(9)
                startActivity(intent)
                finish()
            }
            R.id.buttonK->
            {
                spEdit.putInt("letter", 10)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(10)
                startActivity(intent)
                finish()
            }
            R.id.buttonL->
            {
                spEdit.putInt("letter", 11)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(11)
                startActivity(intent)
                finish()
            }
            R.id.buttonM->
            {
                spEdit.putInt("letter", 12)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(12)
                startActivity(intent)
                finish()
            }
            R.id.buttonN->
            {
                spEdit.putInt("letter", 13)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(13)
                startActivity(intent)
                finish()
            }
            R.id.buttonO->
            {
                spEdit.putInt("letter", 14)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(14)
                startActivity(intent)
                finish()
            }
            R.id.buttonP->
            {
                spEdit.putInt("letter", 15)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(15)
                startActivity(intent)
                finish()
            }
            R.id.buttonQ->
            {
                spEdit.putInt("letter", 16)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(16)
                startActivity(intent)
                finish()
            }
            R.id.buttonR->
            {
                spEdit.putInt("letter", 17)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(17)
                startActivity(intent)
                finish()
            }
            R.id.buttonS->
            {
                spEdit.putInt("letter", 18)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(18)
                startActivity(intent)
                finish()
            }
            R.id.buttonT->
            {
                spEdit.putInt("letter", 19)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(19)
                startActivity(intent)
                finish()
            }
            R.id.buttonU->
            {
                spEdit.putInt("letter", 20)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(20)
                startActivity(intent)
                finish()
            }
            R.id.buttonV->
            {
                spEdit.putInt("letter", 21)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(21)
                startActivity(intent)
                finish()
            }
            R.id.buttonW->
            {
                spEdit.putInt("letter", 22)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(22)
                startActivity(intent)
                finish()
            }
            R.id.buttonX->
            {
                spEdit.putInt("letter", 23)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(23)
                startActivity(intent)
                finish()
            }
            R.id.buttonY->
            {
                spEdit.putInt("letter", 24)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(24)
                startActivity(intent)
                finish()
            }
            R.id.buttonZ->
            {
                spEdit.putInt("letter", 25)
                spEdit.commit()

                val intent = Intent(this@OverviewActivity,LetterActivity::class.java)

                presenter.setImageIn(25)
                startActivity(intent)
                finish()
            }
        }

    }

    fun buttonCreate(){

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

    }

}