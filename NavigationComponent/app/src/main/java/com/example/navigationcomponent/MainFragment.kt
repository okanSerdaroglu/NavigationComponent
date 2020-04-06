package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment : Fragment(), View.OnClickListener {

    lateinit var buttonViewTransactions: Button
    lateinit var buttonSendMoney: Button
    lateinit var buttonViewBalance: Button
    lateinit var navController: NavController // declare a NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        buttonViewTransactions = view.findViewById(R.id.view_transactions_btn)
        buttonSendMoney = view.findViewById(R.id.send_money_btn)
        buttonViewBalance = view.findViewById(R.id.view_balance_btn)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonViewTransactions.setOnClickListener(this)
        buttonSendMoney.setOnClickListener(this)
        buttonViewBalance.setOnClickListener(this)
        navController =
            Navigation.findNavController(view) // initialize NavController passing the view


    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.view_transactions_btn -> {
                navController.navigate(R.id.action_mainFragment_to_viewTransactionsFragment)
            }
            R.id.send_money_btn -> {
                navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            }
            R.id.view_balance_btn -> {
                navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
            }
        }

    }

}
