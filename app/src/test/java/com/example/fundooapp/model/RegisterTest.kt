package com.example.fundooapp.model

import org.junit.Assert
import org.junit.Test

class RegisterTest {

    @Test
    // function for null check
    fun givenUserOneAndNull_WhenEquals_ShouldNotBeEqual(){
        val userOne = RegisterModel(firstname = "Pavan",lastname = "Kumar",username = "pavan123@gmail.com",password="pavan@123")
        val userTwo = null
        Assert.assertFalse(userOne.equals(userTwo))
    }

    @Test
    // function for reference check
    fun givenSameUser_WhenEquals_ShouldBeEqual() {
        val userOne = RegisterModel(firstname = "Pavan", lastname = "Kumar", username = "pavan123@gmail.com", password = "pavan@123")
        Assert.assertTrue(userOne.equals(userOne))
    }

    @Test
    // function when password length is less than three
    fun givenUserOneAndUserTwo_WhenPasswordLengthLessThanThree_ShouldNotBeEqual() {
        val userOne = RegisterModel(firstname = "Pavan",lastname = "Kumar",username = "pavan123@gmail.com",password="12")
        val userTwo = RegisterModel(firstname = "Ravi",lastname = "Krishna",username = "ravi123@gmail.com",password="34")
        Assert.assertFalse(userOne.equals(userTwo))
    }
}