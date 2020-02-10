package com.example.calories


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private  lateinit var feet: EditText
    private lateinit var inches:EditText
    private lateinit var weight: EditText
    private lateinit var calculate :Button
    private lateinit var result:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var root = inflater.inflate(R.layout.fragment_login, container, false)

        feet = root.findViewById(R.id.edit_ft)
        inches= root.findViewById(R.id.edit_inches)
        weight = root.findViewById(R.id.edit_weight)
        calculate = root.findViewById(R.id.btncalculate)

        calculate.setOnClickListener {
            calculateBMIFunction()
          }

        return root

    }
    private fun calculateBMIFunction(){


        val strFeet = feet.text.toString()
        val strInches =inches.text.toString()
        val strWeight = weight.text.toString()
        val valFeet : Float
        val valInches : Float
        val valWeight: Float


        if (TextUtils.isEmpty(strFeet))
        {
            feet.error="Cannot be empty"
            return
        }
        else
        {
            valFeet=strFeet.toFloat()
        }
        if (TextUtils.isEmpty(strInches))
        {
            inches.error="Cannot be empty"
            return
        }
        else
        {
            valInches=strFeet.toFloat()
        }
        if (TextUtils.isEmpty(strWeight))
        {
            weight.error="Cannot be empty"
            return
        }
        else
        {
            valWeight=strFeet.toFloat()
        }

        val bmi = valWeight/(((valFeet)*12)+valInches)*(((valFeet)*12)+valInches)
         displayBMIFunction(bmi)
    }
    private fun displayBMIFunction(bmi:Float){
        val strResult: String
        val bmiLevel: String = when{
            bmi<16 ->"Severely UnderWeight"
            bmi<18.25 -> "UnderWeight"
            bmi<25->"Normal"
            bmi<30-> "OverWeight"
            else ->"Obese"
        }
        strResult= "$bmi lb/feet  \n $bmiLevel "
        result.text =strResult
    }


}
