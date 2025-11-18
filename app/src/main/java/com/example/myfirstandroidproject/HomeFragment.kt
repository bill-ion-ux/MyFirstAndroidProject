package com.example.myfirstandroidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val BtnCat = view.findViewById<Button>(R.id.BtnCat)
        val BtnDog = view.findViewById<Button>(R.id.BtnDog)

        BtnCat.setOnClickListener {
            view.findNavController().navigate(R.id.DestCat)
        }
        BtnDog.setOnClickListener {
            view.findNavController().navigate(R.id.DestDog)
        }


        return view;
    }
}