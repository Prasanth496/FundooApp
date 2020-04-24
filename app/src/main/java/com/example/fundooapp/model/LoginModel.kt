package com.example.fundooapp.model

class LoginModel (val email : String, val password : String){

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if(other !is LoginModel) return false
        return true
    }
}