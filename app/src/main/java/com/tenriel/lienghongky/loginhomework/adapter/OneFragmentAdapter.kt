package com.tenriel.lienghongky.loginhomework.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tenriel.lienghongky.loginhomework.R

/**
 * Created by ckcc-imac17 on 9/27/18.
 */
class OneFragmentAdapter(var context:Context): RecyclerView.Adapter<OneFragmentAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            val inflater = LayoutInflater.from(context)
            var view = inflater.inflate(R.layout.fragment_one_viewholder,parent,false)

        return  viewHolder(view)
    }

    override fun getItemCount(): Int {


        return 100
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       // holder.txv.text = "ok ok ok ok ok"
    }
    class viewHolder(view: View): RecyclerView.ViewHolder(view){
       // var txv = view.findViewById<TextView>(R.id.text)
    }
}

