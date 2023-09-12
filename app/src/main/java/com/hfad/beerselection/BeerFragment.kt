package com.hfad.beerselection

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.fragment.findNavController
/*
Создал фрагмент для выбора сорта пива + спиннер
 */

class BeerFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beer, container, false)
            // инит кнопки которая передает аргумент
        val btnToResult = view.findViewById<Button>(R.id.btnBeer)
        btnToResult.setOnClickListener {
            //инит спиннера
            val spinner = view.findViewById<Spinner>(R.id.spinner)
                //Получение значения элементов из списка с помощью selectedItem
            val selectionBeer = spinner.selectedItem.toString()
            //получаем метод со списками
            val selectionBeerList = getBeers(selectionBeer)
            val beers = selectionBeerList.reduce { str, item -> str + '\n' + item }

            /**
             * Использую навигацию.
             * Через сгенирированный класс получаем id действия
             * Получаем контроллер нав и даею команду "перейти к новой цели" и помещаем в него аргумент
             */
            val action =
                BeerFragmentDirections.actionBeerFragmentToBeerResultFragment(beers)
            findNavController().navigate(action)

        }

        return view
    }
//метод с данными(списками)
    private fun getBeers(beer: String): List<String> {
        return when (beer) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }


}