package com.app.democleanarch.domain.repository

import androidx.lifecycle.MutableLiveData


interface ListRepository {
    fun getData(): MutableLiveData<ArrayList<String>>
}