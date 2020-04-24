package com.example.fundooapp.model

class LoginModel (val email : String, val password : String){

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if(other === this) return true
        if(other !is LoginModel) return false
        other as LoginModel
        return (other.email== this.email).and(other.password==this.password)
    }
}