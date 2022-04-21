package com.clydelizardo.stackexchangeusers.userlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.clydelizardo.stackexchangeusers.databinding.FragmentUserSearchListBinding
import com.clydelizardo.stackexchangeusers.userlist.viewmodel.UserSearchListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSearchListFragment : Fragment() {
    private var binding: FragmentUserSearchListBinding? = null
    private val viewModel: UserSearchListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUserSearchListBinding.inflate(inflater, container, false).also {
            binding = it
            it.viewModel = viewModel
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}