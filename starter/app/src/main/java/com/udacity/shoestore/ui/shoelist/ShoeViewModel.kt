package com.udacity.shoestore.ui.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoe = MutableLiveData<List<Shoe>>()
    val shoe: LiveData<List<Shoe>> get() = _shoe
    var shoeList = mutableListOf<Shoe>()
    var name=MutableLiveData<String>()
    var size=MutableLiveData<Double>()
    var company=MutableLiveData<String>()
    var description=MutableLiveData<String>()

    var shoeSize=0.0
    var shoeName=""
    var shoeDescription=""
    var shoeCompany=""

    init {
        _shoe.value = shoeList
    }

    fun addItem() {
        name.value=shoeName
        size.value=shoeSize
        company.value=shoeCompany
        description.value=shoeDescription

        shoeList.add(Shoe(name.value?:"",size?.value?:0.0,company?.value?:"",description?.value?:""))


        Log.i("ViewModel","Shoe is ${shoeList.size}")
    }
    fun reInitShoe(){
        shoeSize=0.0
        shoeName=""
        shoeDescription=""
        shoeCompany=""

    }

}