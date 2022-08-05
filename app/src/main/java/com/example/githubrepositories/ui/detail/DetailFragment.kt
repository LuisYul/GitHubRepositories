package com.example.githubrepositories.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubrepositories.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val bundle = arguments ?: return
            val args = DetailFragmentArgs.fromBundle(bundle)
            tvAuthor.text = String.format("%s%s", "Author: ", args.repository.author)
            tvName.text = args.repository.name
            tvUrl.text = args.repository.url

            icBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}