package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class BlankFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG","Attached")
        Toast.makeText(requireContext(),"Attached",Toast.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG","Created")
        Toast.makeText(requireContext(),"Created",Toast.LENGTH_LONG).show()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        Log.d("TAG","CreatedView")
        Toast.makeText(requireContext(),"CreatedView",Toast.LENGTH_LONG).show()

        return inflater.inflate(R.layout.fragment_blank, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG","ViewCreated")
        Toast.makeText(requireContext(),"ViewCreated",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","Resume")
        Toast.makeText(requireContext(),"Resume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG","Pause")
        Toast.makeText(requireContext(),"Pause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG","Destroy")
        Toast.makeText(requireContext(),"Destroy",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG","Attached")
        Toast.makeText(requireContext(),"Attached",Toast.LENGTH_LONG).show()
    }

}