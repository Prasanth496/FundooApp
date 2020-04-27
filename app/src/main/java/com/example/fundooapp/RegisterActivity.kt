package com.example.fundooapp

import android.R
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.example.fundooapp.model.User


class RegisterActivity : AppCompatActivity() {


    //Declaring EditTexts
    var editTextUserName: EditText? = null
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null

    //Declaring TextInputLayout
    var textInputLayoutUserName: TextInputLayout? = null
    var textInputLayoutEmail: TextInputLayout? = null
    var textInputLayoutPassword: TextInputLayout? = null

    //Declaring Button
    var buttonRegister: Button? = null

    //Declaration SqliteHelper
    var sqliteHelper: SqliteHelper? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        sqliteHelper = SqliteHelper(this)
        initTextViewLogin()
        initViews()
        buttonRegister.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(view: View?) {
                if (validate()) {
                    val UserName = editTextUserName!!.text.toString()
                    val Email = editTextEmail!!.text.toString()
                    val Password = editTextPassword!!.text.toString()
                    //Check in the database is there any user associated with  this email
                    if (!sqliteHelper!!.isEmailExists(Email)) { //Email does not exist now add new user to database
                        sqliteHelper!!.addUser(User(null, UserName, Email, Password))
                        Snackbar.make(
                            buttonRegister,
                            "User created successfully! Please Login ",
                            Snackbar.LENGTH_LONG
                        ).show()
                        Handler().postDelayed(Runnable { finish() }, Snackbar.LENGTH_LONG)
                    } else { //Email exists with email input provided so show error user already exist
                        Snackbar.make(
                            buttonRegister,
                            "User already exists with same email ",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
        })
    }

    //this method used to set Login TextView click event
    private fun initTextViewLogin() {
        val textViewLogin = findViewById(R.id.textViewLogin) as TextView
        textViewLogin.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(view: View?) {
                finish()
            }
        })
    }

    //this method is used to connect XML views to its Objects
    private fun initViews() {
        editTextEmail = findViewById(R.id.editTextEmail) as EditText
        editTextPassword = findViewById(R.id.editTextPassword) as EditText
        editTextUserName = findViewById(R.id.editTextUserName) as EditText
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail) as TextInputLayout?
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword) as TextInputLayout?
        textInputLayoutUserName = findViewById(R.id.textInputLayoutUserName) as TextInputLayout?
        buttonRegister = findViewById(R.id.buttonRegister) as Button?
    }

    //This method is used to validate input given by user
    fun validate(): Boolean {
        var valid = false
        //Get values from EditText fields
        val UserName = editTextUserName!!.text.toString()
        val Email = editTextEmail!!.text.toString()
        val Password = editTextPassword!!.text.toString()
        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false
            textInputLayoutUserName.setError("Please enter valid username!")
        } else {
            if (UserName.length > 5) {
                valid = true
                textInputLayoutUserName.setError(null)
            } else {
                valid = false
                textInputLayoutUserName.setError("Username is to short!")
            }
        }
        //Handling validation for Email field
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false
            textInputLayoutEmail.setError("Please enter valid email!")
        } else {
            valid = true
            textInputLayoutEmail.setError(null)
        }
        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false
            textInputLayoutPassword.setError("Please enter valid password!")
        } else {
            if (Password.length > 5) {
                valid = true
                textInputLayoutPassword.setError(null)
            } else {
                valid = false
                textInputLayoutPassword.setError("Password is to short!")
            }
        }
        return valid
    }
}
