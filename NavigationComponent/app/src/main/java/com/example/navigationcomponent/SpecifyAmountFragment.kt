package com.example.navigationcomponent

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*


class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonSend: Button
    private lateinit var buttonCancel: Button
    private lateinit var navController: NavController
    private lateinit var recepientMessage: String
    private lateinit var textViewInputAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recepientMessage = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_specify_amount, container, false)
        buttonSend = view.findViewById(R.id.send_btn)
        buttonCancel = view.findViewById(R.id.cancel_btn)
        textViewInputAmount = view.findViewById(R.id.input_amount)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSend.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
        navController = Navigation.findNavController(view)
        val message = "sending money to $recepientMessage"
        view.findViewById<TextView>(R.id.recipient).text = message
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(textViewInputAmount.text.toString())) {
                    val money = Money(textViewInputAmount.text.toString(), recepientMessage)
                    val bundle = bundleOf("amount" to money)
                    navController.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                }


            }
            R.id.cancel_btn -> {
                activity!!.onBackPressed()
            }
        }
    }


}
