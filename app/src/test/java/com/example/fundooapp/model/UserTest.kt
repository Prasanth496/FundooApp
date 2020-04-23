package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class UserTest {

    @Test
    // function for null check
    fun givenUserOneAndNull_WhenEquals_ShouldNotBeEqual() {
        val userOne = Userlogin(email = "pavan123@gmail.com", password = "pavan@123")
        val userTwo = null
        Assert.assertFalse(userOne == userTwo)
    }

    @Test
    // function for reference check
    fun givenSameUser_WhenEquals_ShouldBeEqual() {
        val userOne = Userlogin(email = "pavan123@gmail.com",password = "pavan@123")
        Assert.assertTrue(userOne.equals(userOne))
    }

    @Test
    // function for values are equal check
    fun givenUserOneAndUserTwoWithSameDetails_Whenequals_ShouldBeEqual() {
        val userOne = Userlogin(email = "pavan123@gmail.com",password = "pavan@123")
        val userTwo = UserLogin(name = "Pavan",mobileNumber = "9543216423",email = "pavan123@gmail.com")
        Assert.assertTrue(userOne.equals(userTwo))
    }



}