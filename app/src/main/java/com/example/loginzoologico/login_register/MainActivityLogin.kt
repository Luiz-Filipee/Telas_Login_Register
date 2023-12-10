package com.example.loginzoologico.login_register

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.loginzoologico.R

class MainActivityLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginValidate()
    }

    private fun isPasswordValid(password: String) : Boolean {
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$".toRegex()
        return passwordRegex.matches(password)
    }

    private fun loginValidate(){
        val btn_login: Button = findViewById(R.id.btn_login)
        val et_senha: EditText = findViewById(R.id.et_senha)
        val et_email_login: EditText = findViewById(R.id.et_email_login)

        btn_login.setOnClickListener {
            val password = et_senha.text.toString()
            val email = et_email_login.text.toString()

            if (email.isEmpty() && password.isEmpty()){
                showToast("Dados nao reconhecidos. Por favor tente novamente")
            }else{
                if(!email.isEmpty()){
                    if(isEmailValid(email)){
                        //showToast("Email válido!")
                    }else{
                        showToast("Email inválido!")
                    }
                }else{
                    showToast("Informe um email!")
                }
                if(!password.isEmpty()) {
                    if(isPasswordValid(password)){
                        //showToast("Senha válida!")
                    }else {
                        showToast("Senha inválida!" +
                                "A senha deve conter 8 caracteres" +
                                "A senha deve conter no minimo uma letra minuscula" +
                                "A senha deve conter no minimo uma letra maiuscula" +
                                "A senha deve conter um carater especial (#$@%...)")
                    }
                }
                }
            }
        }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        return email.matches(emailRegex)
    }


}


