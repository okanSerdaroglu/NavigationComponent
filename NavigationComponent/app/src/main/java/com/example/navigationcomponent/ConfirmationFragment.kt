package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment(),View.OnClickListener {


    private lateinit var money: Money
    private lateinit var message: String
    private lateinit var navController:NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        money = arguments?.getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        message = """${money.amount} was send to ${money.name}"""
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        buttonBack.setOnClickListener(this)
        confirmation_message.text = message
    }


    override fun onClick(v: View?) {
        navController.navigate(R.id.action_confirmationFragment_to_chooseRecipientFragment)
    }


}
