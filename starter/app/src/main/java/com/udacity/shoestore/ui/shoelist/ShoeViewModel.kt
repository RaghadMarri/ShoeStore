package com.udacity.shoestore.ui.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoe = MutableLiveData<List<Shoe>>()
    val shoe: LiveData<List<Shoe>> get() = _shoe
    var shoeList = mutableListOf<Shoe>()

    init {
        _shoe.value = shoeList
    }

    fun addItem(shoeItem: Shoe) {
        shoeList.add(shoeItem)
    }

}