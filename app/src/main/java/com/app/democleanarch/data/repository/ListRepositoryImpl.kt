package com.app.democleanarch.data.repository

import androidx.lifecycle.MutableLiveData
import com.app.democleanarch.domain.repository.ListRepository

class ListRepositoryImpl : ListRepository {
    private var userData = MutableLiveData<ArrayList<String>>()
    private var data = ArrayList<String>()

    override fun getData(): MutableLiveData<ArrayList<String>> {
        setData()
        userData.value = data
        return userData
    }

    private fun setData() {
        data.add("One")
        data.add("two")
    }
}