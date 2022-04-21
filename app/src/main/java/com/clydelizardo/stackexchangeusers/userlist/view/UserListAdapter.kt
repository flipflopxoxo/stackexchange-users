package com.clydelizardo.stackexchangeusers.userlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.clydelizardo.stackexchangeusers.BR
import com.clydelizardo.stackexchangeusers.userlist.view.model.UserListItem

class UserListAdapter: ListAdapter<UserListItem<*>, UserListViewHolder>(UserListDiff) {
    override fun getItemViewType(position: Int): Int {
        return getItem(position).resourceId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = DataBindingUtil.bind<ViewDataBinding>(view)

    fun bind(item: UserListItem<*>) {
        if (item.content != null) {
            binding?.setVariable(BR.viewModel, item.content)
        }
    }
}

object UserListDiff: DiffUtil.ItemCallback<UserListItem<*>>() {
    override fun areItemsTheSame(oldItem: UserListItem<*>, newItem: UserListItem<*>): Boolean {
        return when (oldItem) {
            is UserListItem.User -> {
               newItem is UserListItem.User && oldItem.content.id == newItem.content.id
            }
            else -> {
                newItem == newItem
            }
        }
    }

    override fun areContentsTheSame(oldItem: UserListItem<*>, newItem: UserListItem<*>): Boolean {
        return oldItem == newItem
    }
}