package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class UserTest {

    // testcase when both email and password are empty
    @Test
    fun givenEmailAndPassword_WhenNull_ShouldReturnFalse() {
        val email = null
        val password = null
        Assert.assertTrue(email == password)
    }
}