package com.example.livedatademo.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    var owner : String = ""

    //var act as variable (changeable value)
    private var _balance = MutableLiveData<Double>()

    // val only view
    val balance : LiveData<Double>
                    get() = _balance

    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }

    fun deposit(amount: Double) {
        _balance.value = (_balance.value)?.plus(amount)
    }

    fun withdraw(amount:Double){
        _balance.value = (_balance.value)?.minus(amount)
    }

}