package com.app.democleanarch.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.democleanarch.data.repository.ListRepositoryImpl
import com.app.democleanarch.domain.usecase.GetHomeUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
     var mutableList = MutableLiveData<ArrayList<String>>()
    private var getHomeUseCase: GetHomeUseCase
    private val disposables = CompositeDisposable()

    init {
        val listRepositoryImpl = ListRepositoryImpl()
        getHomeUseCase = GetHomeUseCase(listRepositoryImpl)
        getUserList()
    }

    private fun getUserList() {
        getHomeUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is GetHomeUseCase.Result.Success -> {
                        mutableList.value = it.newVal
                    }
                    is GetHomeUseCase.Result.Failure -> {
                    }
                }
            }
            .addTo(disposables)
    }



}