package com.example.alfagift

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.masuk)

        emailEditText.requestFocus()

        passwordEditText.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (passwordEditText.right - passwordEditText.compoundDrawables[2].bounds.width())) {
                    if (passwordEditText.transformationMethod is PasswordTransformationMethod) {
                        passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    } else {
                        passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                    }
                    passwordEditText.setSelection(passwordEditText.text.length)
                    return@setOnTouchListener true
                }
            }
            false
        }

        loginButton.setOnClickListener {
            val username = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username and password cannot be null", Toast.LENGTH_SHORT).show()
            } else if (username == "alfagift-admin" && password == "asdf") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}