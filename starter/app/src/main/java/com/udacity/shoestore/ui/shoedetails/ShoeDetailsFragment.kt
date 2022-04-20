package com.udacity.shoestore.ui.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.shoelist.ShoeViewModel

class ShoeDetailsFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailsBinding
    val viewModel:ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_shoeDetailsFragment_to_shoeListFragment
            )
        }
        binding.addButton.setOnClickListener {
                 viewModel.addItem()
                view?.findNavController()?.navigate(
                   R.id.action_shoeDetailsFragment_to_shoeListFragment
                )

        }
        viewModel.reInitShoe()
        binding.viewModel=viewModel
        binding.lifecycleOwner=this
        return binding.root
    }

}