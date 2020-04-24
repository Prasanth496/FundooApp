package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class RegisterTest {

    @Test
    // function for null check
    fun givenUserOneAndNull_WhenEquals_ShouldNotBeEqual(){
        val userOne = RegisterModel(firstname = "Pavan",lastname = "Kumar",username = "pavan123@gmail.com",password="pavan@123")
        val userTwo = null
        Assert.assertFalse(userOne == userTwo)
    }
}