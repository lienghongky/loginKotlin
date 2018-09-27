package com.tenriel.lienghongky.loginhomework.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.tenriel.lienghongky.loginhomework.R
import com.tenriel.lienghongky.loginhomework.adapter.OneFragmentAdapter
import kotlinx.android.synthetic.main.fragment_one.*


class OneFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val rw = view.findViewById<RecyclerView>(R.id.rwFragmentOne)
        rw.adapter=OneFragmentAdapter(context!!)
        rw.layoutManager = LinearLayoutManager(context)


        return view
    }

    override fun onResume() {
        super.onResume()


    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)
        //Find the +1 button


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

}

