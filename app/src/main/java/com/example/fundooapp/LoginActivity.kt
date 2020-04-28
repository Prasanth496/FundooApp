package com.example.fundooapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fundooapp.model.User


class LoginActivity : AppCompatActivity() {


    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null

    //Declaration TextInputLayout
    var textInputLayoutEmail: TextInputLayout? = null
    var textInputLayoutPassword: TextInputLayout? = null

    //Declarating Button
    var buttonLogin: Button? = null

    //Declaring SqliteHelper
    var sqliteHelper: SqliteHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sqliteHelper = SqliteHelper(this)
        initCreateAccountTextView()
        initViews()
        //set click event of login button
        buttonLogin?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {
                if (validate()) {              //Get values from EditText fields
                    val Email = editTextEmail!!.text.toString()
                    val Password = editTextPassword!!.text.toString()
                    //Authenticate user
                    val currentUser: User? =
                        sqliteHelper!!.Authenticate(User(email,password))
                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG)
                            .show()
                        //User Logged in Successfully Launch You home screen activity
                    } else {                     //User Logged is Failed
                        Snackbar.make(
                            buttonLogin,
                            "Failed to log in , please try again",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
        })
    }


    private fun initCreateAccountTextView() {
        val textViewCreateAccount = findViewById(R.id.textViewCreateAccount) as TextView
        textViewCreateAccount.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(view: View?) {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        })
    }

    //this method is used to connect XML views to its Objects
    private fun initViews() {
        editTextEmail = findViewById(R.id.editTextEmail) as EditText
        editTextPassword = findViewById(R.id.editTextPassword) as EditText
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail) as TextInputLayout?
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword) as TextInputLayout?
        buttonLogin = findViewById(R.id.login) as Button?
    }


    //This method is used to validate input given by user
    fun validate(): Boolean {
        var valid = false
        //Get values from EditText fields
        val Email = editTextEmail!!.text.toString()
        val Password = editTextPassword!!.text.toString()

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
