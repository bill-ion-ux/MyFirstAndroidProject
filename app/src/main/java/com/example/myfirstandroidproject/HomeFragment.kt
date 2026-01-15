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


    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * This method inflates the layout for the home screen, which includes buttons
     * to navigate to different sections of the app (e.g., Cat and Dog details).
     * It sets up click listeners on these buttons to trigger navigation actions
     * using the Navigation Component.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     *                  The fragment should not add the view itself, but this can be used to generate
     *                  the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous
     *                           saved state as given here.
     * @return The View for the fragment's UI, or null.
     */
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