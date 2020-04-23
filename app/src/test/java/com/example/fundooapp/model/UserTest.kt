package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class UserTest {

    // function for null check
    @Test
    fun givenUserOneAndNull_WhenEquals_ShouldNotBeEqual() {
        val userOne = Userlogin(email = "pavan123@gmail.com", password = "pavan@123")
        val userTwo = null
        Assert.assertFalse(userOne == userTwo)
    }



}