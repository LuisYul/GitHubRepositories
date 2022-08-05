package com.example.githubrepositories.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.RepositoryModel
import com.example.githubrepositories.databinding.ItemListRepositoryBinding

class RepositoryAdapter : PagingDataAdapter<RepositoryModel,
        RepositoryAdapter.ViewHolder>(REPO_DIFF) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = getItem(position)
        if (repository != null) {
            holder.bind(repository)
        }
    }

    inner class ViewHolder(private val binding: ItemListRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RepositoryModel) {
            with(binding) {
                tvName.text = data.name
                tvAuthor.text = data.author
                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }
            }
        }
    }

    companion object {
        private val REPO_DIFF = object : DiffUtil.ItemCallback<RepositoryModel>() {
            override fun areItemsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RepositoryModel, newItem: RepositoryModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: RepositoryModel)
    }

}