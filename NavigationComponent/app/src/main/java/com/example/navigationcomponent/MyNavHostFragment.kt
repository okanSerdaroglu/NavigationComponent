package com.example.navigationcomponent

import androidx.navigation.fragment.NavHostFragment

class MyNavHostFragment : NavHostFragment() {
    override fun createFragmentNavigator() =
        MyFragmentNavigator(requireContext(), childFragmentManager, id)
}