package com.tenriel.lienghongky.loginhomework

import android.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.tenriel.lienghongky.loginhomework.fragments.OneFragment
import com.tenriel.lienghongky.loginhomework.fragments.ThreeFragment
import com.tenriel.lienghongky.loginhomework.fragments.TwoFragment
import kotlinx.android.synthetic.main.activity_fragment_container.*
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_three.*
import kotlinx.android.synthetic.main.fragment_two.*

class FragmentContainerActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        btnNex.callOnClick()
    }

    var fragments:List<android.support.v4.app.Fragment>? = null
     var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        fragments = listOf(
                OneFragment(),
                TwoFragment(),
                ThreeFragment()
        )
        val click:((View)->Unit) = {
            btnNex.callOnClick()
        }

        (this.fragments!![1] as TwoFragment).onClick = click
        (this.fragments!![2] as ThreeFragment).onClick = click



        moveFragments(i)
    btnNex.setOnClickListener {
        i++
        if (i > fragments!!.size-1){
            i=0
        }
        moveFragments(i)
    }
        btnPre.setOnClickListener {

                i--
                if (i < 0){
                    i=fragments!!.size-1
                }
                moveFragments(i)

        }


    }

     fun moveFragments(index:Int){
         var fragmentManager = supportFragmentManager
                 .beginTransaction()
                 .replace(R.id.fragment_container, fragments!![index])
                 .commit()
     }
}
