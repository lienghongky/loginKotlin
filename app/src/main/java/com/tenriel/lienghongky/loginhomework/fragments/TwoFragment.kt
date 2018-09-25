package com.tenriel.lienghongky.loginhomework.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.tenriel.lienghongky.loginhomework.R
import com.google.android.gms.plus.PlusOneButton


class TwoFragment : Fragment() {
    var onClick:((View)->Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        var btn = view.findViewById<Button>(R.id.btn2)
        btn.setOnClickListener {
            onClick!!(btn)

        }
        //Find the +1 button

        return view
    }

    override fun onResume() {
        super.onResume()


    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }


    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        // The request code must be 0 or greater.
        private val PLUS_ONE_REQUEST_CODE = 0


        fun newInstance(param1: String, param2: String): PlusOneFragment {
            val fragment = PlusOneFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
