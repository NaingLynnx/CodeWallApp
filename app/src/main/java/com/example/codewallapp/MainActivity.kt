package com.example.codewallapp

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

   private lateinit var msliderViewPager: ViewPager
   private lateinit var mDotLayout : LinearLayout
   private lateinit var skipbtn : Button

   private lateinit var dots: Array<TextView>
   private lateinit var viewPagerAdapter: ViewPagerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        skipbtn=findViewById(R.id.skipButton)


        skipbtn.setOnClickListener(View.OnClickListener { v ->  })

        msliderViewPager =findViewById(R.id.slideViewpager)
        mDotLayout=findViewById(R.id.indicator_layout)

        viewPagerAdapter=ViewPagerAdapter(this)

        msliderViewPager.adapter=viewPagerAdapter




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setUpindicator(position :Int ){


        val numberOfDots = 3
        dots = Array(numberOfDots) { TextView(this) }
        mDotLayout.removeAllViews()

        for(i in dots.indices){
            dots[i] = TextView(this)
            dots[i].setText(Html.fromHtml("&#8226"))
            dots[i].textSize

        }

    }



}