package com.clydelizardo.stackexchangeusers.userdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.clydelizardo.stackexchangeusers.databinding.FragmentUserDetailsBinding
import com.clydelizardo.stackexchangeusers.userdetails.viewmodel.UserDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment: Fragment() {
    private var binding: FragmentUserDetailsBinding? = null
    private val viewModel: UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUserDetailsBinding.inflate(inflater, container, false).also{
            it.viewModel = viewModel
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}