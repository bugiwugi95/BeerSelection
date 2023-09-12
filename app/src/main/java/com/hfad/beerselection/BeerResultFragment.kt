package com.hfad.beerselection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BeerResultFragment : Fragment() {
//Этот фрагмент для отображения получаемого аргумента от фрагмента BeerFragment.Также через сгенирированный класс BeerResultFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result_beer, container, false)
        val textViewBeer = view.findViewById<TextView>(R.id.textViewBeer)
        val args = BeerResultFragmentArgs.fromBundle(requireArguments()).beer
        textViewBeer.text = args

        return view
    }


}