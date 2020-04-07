package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class SpecifyAmountFragment : Fragment(),View.OnClickListener {

    private lateinit var buttonSend : Button
    private lateinit var buttonCancel : Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_specify_amount,container,false)
        buttonSend = view.findViewById(R.id.send_btn)
        buttonCancel = view.findViewById(R.id.cancel_btn)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSend.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send_btn -> {
              navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
            }
            R.id.cancel_btn -> {
              activity!!.onBackPressed()
            }
        }
    }


}
