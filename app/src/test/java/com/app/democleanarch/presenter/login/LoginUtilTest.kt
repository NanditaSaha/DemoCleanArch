package com.app.democleanarch.presenter.login


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginUtilTest {

    @Test
    fun emptyEmailCheck(){
        val result=LoginUtil.validLoginCheck(
            "","123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPasswordCheck(){
        val result=LoginUtil.validLoginCheck(
            "anc@gmail.com",""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validPasswordLengthCheck(){
        val result=LoginUtil.validLoginCheck(
            "anc@gmail.com","12"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validInputCheck(){
        val result=LoginUtil.validLoginCheck(
            "anc@gmail.com","123456"
        )
        assertThat(result).isTrue()
    }


}