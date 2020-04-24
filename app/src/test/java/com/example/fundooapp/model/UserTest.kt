package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class UserTest {

    @Test
    // function for null check
    fun givenUserOneAndNull_WhenEquals_ShouldNotBeEqual() {
        val userOne = LoginModel(email = "pavan123@gmail.com", password = "pavan@123")
        val userTwo = null
        Assert.assertFalse(userOne == userTwo)
    }

    @Test
    // function for reference check
    fun givenSameUser_WhenEquals_ShouldBeEqual() {
        val userOne = LoginModel(email = "pavan123@gmail.com", password = "pavan@123")
        Assert.assertTrue(userOne.equals(userOne))
    }

    @Test
    // function for values are equal check
    fun givenUserOneAndUserTwoWithSameDetails_Whenequals_ShouldBeEqual() {
        val userOne = LoginModel(email = "pavan123@gmail.com", password = "pavan@123")
        val userTwo = LoginModel(email = "pavan123@gmail.com", password = "pavan@123")
        Assert.assertTrue(userOne.equals(userTwo))
    }

    @Test
    // function for value and string check
    fun givenUserOneAndString_WhenEquals_ShouldNotBeEqual() {
        val userOne = LoginModel(email = "pavan123@gmail.com", password = "pavam@123")
        val userTwo = "Ravi"
        Assert.assertFalse(userOne.equals(userTwo))
    }

    @Test
    //function for value are not equal check
    fun givenUserOneAndUserTwoWithDifferentDetails_Whenequals_ShouldNotBeEqual() {
        val userOne = LoginModel(email = "pavan123@gmail.com", password = "pavan@123")
        val userTwo = LoginModel(email = "ravi234@gmail.com", password = "ravi@123")
        Assert.assertFalse(userOne.equals(userTwo))
    }
}
