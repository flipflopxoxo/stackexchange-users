package com.clydelizardo.stackexchangeusers.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clydelizardo.stackexchangeusers.databinding.FragmentUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment: Fragment() {
    private var binding: FragmentUserDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUserDetailsBinding.inflate(inflater, container, false).root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}