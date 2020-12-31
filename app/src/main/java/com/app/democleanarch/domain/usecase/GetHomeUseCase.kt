package com.app.democleanarch.domain.usecase

import com.app.democleanarch.domain.repository.ListRepository
import io.reactivex.Observable

class GetHomeUseCase(private val listRepository: ListRepository) {
    sealed class Result {
        data class Success(val newVal: ArrayList<String>) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    fun execute(): Observable<Result> {
        return Observable.just(listRepository.getData())
            .map {
                Result.Success(it.value!!)
            }

    }

}