package com.example.githubrepositories.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.RepositoryModel
import com.example.githubrepositories.R
import com.example.githubrepositories.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModel()
    private val repositoryAdapter: RepositoryAdapter = RepositoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.repositories.observe(viewLifecycleOwner) {
            repositoryAdapter.submitData(viewLifecycleOwner.lifecycle, it)
            binding.progressCircular.visibility = View.GONE
            showRvRepositories()
        }

        repositoryAdapter.addLoadStateListener { combinedLoadStates ->
            with(binding) {
                swipe.setOnRefreshListener {
                    repositoryAdapter.refresh()
                    swipe.isRefreshing = false
                }
                progressCircular.isVisible = combinedLoadStates.source.refresh is LoadState.Loading
                rvRepository.isVisible = combinedLoadStates.source.refresh is LoadState.NotLoading
                tvError.isVisible = combinedLoadStates.source.refresh is LoadState.Error

                if (combinedLoadStates.source.refresh is LoadState.Error) {
                    rvRepository.isVisible = false
                    tvError.text = getString(R.string.something_went_wrong)
                    tvError.isVisible = true
                }
                if (combinedLoadStates.source.refresh is LoadState.NotLoading
                    && combinedLoadStates.append.endOfPaginationReached && repositoryAdapter.itemCount < 1
                ) {
                    rvRepository.isVisible = false
                    tvError.text = getString(R.string.something_went_wrong)
                    tvError.isVisible = true
                }
            }
        }
    }

    private fun showRvRepositories() {
        with(binding.rvRepository) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = repositoryAdapter
            repositoryAdapter.setOnItemCallback(object : RepositoryAdapter.OnItemClickCallback {
                override fun onItemClicked(data: RepositoryModel) {
                    val action = MainFragmentDirections.actionMainFragmentToDetailFragment(data)
                    findNavController().navigate(action)
                }
            })
        }
    }

}