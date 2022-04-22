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

class UserListAdapter : ListAdapter<UserListItem<*>, UserListViewHolder>(UserListDiff) {
    var onItemSelectedListener: ((UserListItem<*>) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return getItem(position).resourceId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return UserListViewHolder(view) {
            onItemSelectedListener?.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserListViewHolder(
    view: View,
    private val onItemSelected: (UserListItem<*>) -> Unit,
) : RecyclerView.ViewHolder(view) {
    private val binding = DataBindingUtil.bind<ViewDataBinding>(view)

    fun bind(item: UserListItem<*>) {
        if (item.content != null) {
            binding?.setVariable(BR.viewModel, item.content)
            itemView.setOnClickListener {
                onItemSelected(item)
            }
        }
    }
}

object UserListDiff : DiffUtil.ItemCallback<UserListItem<*>>() {
    override fun areItemsTheSame(oldItem: UserListItem<*>, newItem: UserListItem<*>): Boolean {
        return when (oldItem) {
            is UserListItem.User -> {
                newItem is UserListItem.User && oldItem.content.id == newItem.content.id
            }
            else -> {
                oldItem == newItem
            }
        }
    }

    override fun areContentsTheSame(oldItem: UserListItem<*>, newItem: UserListItem<*>): Boolean {
        return oldItem == newItem
    }
}