package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding: FragmentShoeListBinding
    lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        linearLayout = binding.linearView
        val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        var shoe: Shoe? = args?.shoe ?: null

        Log.i("ShoeListFragment", "The ${shoe?.name ?: "Raghad"} has been added")
        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }
        if (shoe != null) {
            viewModel.addItem(shoe!!)
            viewModel.shoe.observe(viewLifecycleOwner) { shoe ->
                for (i in shoe) {
                    addNewItem(i)
                }
            }
        }
        setHasOptionsMenu(true)
        return binding.root

    }

    private fun addNewItem(shoe: Shoe) {
        var name = TextView(this.context)
        name.text = "${shoe.name}"
        name.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        var company = TextView(this.context)
        company.text = "${shoe.company}"
        company.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        var size = TextView(this.context)
        size.text = "${shoe.size}"
        size.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        var description = TextView(this.context)
        description.text = "${shoe.description}"
        description.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        linearLayout.addView(name)
        linearLayout.addView(company)
        linearLayout.addView(size)
        linearLayout.addView(description)
        linearLayout.baseline

    }


}