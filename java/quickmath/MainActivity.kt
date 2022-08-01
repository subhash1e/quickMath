package com.subhash1e.quickmath

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.System.currentTimeMillis
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var  btnGo:Button
    lateinit var btn0:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button

    lateinit var tvStatus:TextView
    lateinit var tv1:TextView
    lateinit var tv2:TextView
    private var option:Int = 0
    private var first:Int = 0
    private var second:Int = 0
    private var mResult:Int = 0
    private var pwr:Int = 0
    private var sym:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo= findViewById<Button>(R.id.GO)
        btn0 = findViewById<Button>(R.id.btn0)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        btn3 = findViewById<Button>(R.id.btn3)
        tvStatus = findViewById<TextView>(R.id.tvStatus)
        tv1 = findViewById<TextView>(R.id.textView)
        tv2 = findViewById<TextView>(R.id.textView2)

        var level = intent.getIntExtra("level",1)
        var algo = intent.getIntExtra("algo",1)
        Log.d("main","$level, $algo")
        pwr = ((Math.pow(10.0,level.toDouble()+1)).toInt())
        sym = when(algo){
             1->"+"
             2->"-"
             else -> "*"
        }


       btn0.setOnClickListener {

           if(option==0){
               tvStatus.text = "Correct answer"
           }else{
               tvStatus.text = "Wrong answer, correct is $option"
           }
           updateUI(algo)

       }
         btn1.setOnClickListener {


             if(option==1){
               tvStatus.text = "Correct answer"
           }else{
               tvStatus.text = "Wrong answer, correct is $option"
           }
             updateUI(algo)
       }
         btn2.setOnClickListener {


             if(option==2){
               tvStatus.text = "Correct answer"
           }else{
               tvStatus.text = "Wrong answer, correct is $option"
           }
             updateUI(algo)
       }
         btn3.setOnClickListener {

             if(option==3){
               tvStatus.text = "Correct answer"
           }else{
               tvStatus.text = "Wrong answer, correct is $option"
           }
             updateUI(algo)


         }
        btnGo.setOnClickListener {
            btnGo.visibility = View.INVISIBLE
            updateUI(algo)
        }


    }

    private fun updateUI(algo:Int) {
        first = Random(System.currentTimeMillis()/1000).nextInt()*1007%pwr
        second = Random(System.currentTimeMillis()/1000).nextInt()*1007%pwr
        option =  Random(System.currentTimeMillis()/1000).nextInt()*1007%4

        tv1.text = "$first     $sym"
        tv2.text = "    $second"

        btn0.text = "${mResult*(SystemClock.elapsedRealtime())*107%pwr}"
        btn1.text = "${mResult*(SystemClock.elapsedRealtime())*106%pwr}"
        btn2.text = "${mResult*(SystemClock.elapsedRealtime())*105%pwr}"
        btn3.text = "${mResult*(SystemClock.elapsedRealtime())*104%pwr}"
        mResult = when(algo){
            1->first+second
            2->first-second
            else -> first*second
        }
        option =  abs(option)

        when(option){
            0->{
                if(btn1.text == "$mResult")btn1.text = "${mResult+7}"
                if(btn2.text == "$mResult")btn2.text = "${mResult+6}"
                if(btn3.text == "$mResult")btn3.text = "${mResult+5}"
                btn0.text = "$mResult"
            }
            1->{
                if(btn0.text == "$mResult")btn0.text = "${mResult+7}"
                if(btn2.text == "$mResult")btn2.text = "${mResult+6}"
                if(btn3.text == "$mResult")btn3.text = "${mResult+5}"
                btn1.text = "$mResult"
            }
            2->{
                if(btn1.text == "$mResult")btn1.text = "${mResult+7}"
                if(btn0.text == "$mResult")btn0.text = "${mResult+6}"
                if(btn3.text == "$mResult")btn3.text = "${mResult+5}"
                btn2.text = "$mResult"
            }

            else->{
                if(btn1.text == "$mResult")btn1.text = "${mResult+7}"
                if(btn2.text == "$mResult")btn2.text = "${mResult+6}"
                if(btn0.text == "$mResult")btn0.text = "${mResult+5}"
                btn3.text = "$mResult"
            }

        }



    }
}