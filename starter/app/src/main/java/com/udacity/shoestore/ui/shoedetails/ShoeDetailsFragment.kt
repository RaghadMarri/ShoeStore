package com.udacity.shoestore.ui.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(null)
            )
        }
        binding.addButton.setOnClickListener {
            if (onSaveClicked() != null)
                view?.findNavController()?.navigate(
                    ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(
                        onSaveClicked()
                    )
                )

        }
        return binding.root
    }

    private fun onSaveClicked(): Shoe? {
        var shoeName = binding.name.text.trim()?.toString()
        var shoeSize = binding.size.text.trim().toString()
        var shoeCompany = binding.company.text.trim()?.toString()
        var shoeDescription = binding.description.text.trim()?.toString()
        if (shoeCompany.isNullOrEmpty() || shoeName.isNullOrEmpty()
            || shoeDescription.isNullOrEmpty() || shoeSize.isNullOrEmpty()
        ) {
            Toast.makeText(requireContext(), R.string.fill_missing_data, Toast.LENGTH_SHORT).show()
            return null

        }
        return Shoe(shoeName, shoeSize.toDouble(), shoeCompany, shoeDescription)
    }
}