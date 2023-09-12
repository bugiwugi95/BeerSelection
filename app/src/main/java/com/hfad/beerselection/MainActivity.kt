package com.hfad.beerselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//Ичпользую FragmentContainerView для отображения стартового фрагмента:BeerFragment
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}