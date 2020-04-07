package com.example.navigationcomponent

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonNext: Button
    private lateinit var buttonCancel: Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_choose_recipient, container, false)
        buttonNext = view.findViewById(R.id.next_btn)
        buttonCancel = view.findViewById(R.id.cancel_btn)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        buttonNext.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(input_recipient.text.toString())) {
                    val bundle = bundleOf("recipient" to input_recipient.text.toString())
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
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
