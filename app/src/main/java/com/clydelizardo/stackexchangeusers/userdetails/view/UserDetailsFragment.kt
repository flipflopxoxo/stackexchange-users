package com.clydelizardo.stackexchangeusers.userdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.clydelizardo.stackexchangeusers.R
import com.clydelizardo.stackexchangeusers.databinding.FragmentUserDetailsBinding
import com.clydelizardo.stackexchangeusers.userdetails.viewmodel.UserDetailsViewModel
import com.squareup.picasso.Picasso
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
            binding = it
            it.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.profileImageView?.let {
            Picasso.get()
                .load(viewModel.profileImageUrl)
                .placeholder(R.drawable.ic_baseline_person_256)
                .into(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}