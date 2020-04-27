package com.example.fundooapp.model

class RegisterModel (val firstname : String,val lastname : String,val username : String, val password : String) {

    override fun equals(other: Any?): Boolean {
        if(other == null) return false
        return super.equals(other)
    }
}
