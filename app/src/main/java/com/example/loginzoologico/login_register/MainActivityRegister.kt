package com.example.loginzoologico.login_register

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.loginzoologico.R

class MainActivityRegister : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerValidate()
    }

    private fun registerValidate(){
        val tv_telefone_register: TextView = findViewById(R.id.tv_telefone_register)
        val btn_registrar: Button = findViewById(R.id.btn_registrar)
        val et_senha_register: EditText = findViewById(R.id.et_senha_register)
        val et_email_register: EditText = findViewById(R.id.et_email_register)

        btn_registrar.setOnClickListener {
            val number = tv_telefone_register.text.toString()
            val senha = et_senha_register.text.toString()
            val email = et_email_register.text.toString()

            if (number.isEmpty() && senha.isEmpty() && email.isEmpty()){
                showToast("Dados nao reconhecidos. Tente novamente")
            }else{
                if(!email.isEmpty()){
                    if (isEmailValid(email)){
                        showToast("Email valido!")
                    }else{
                        showToast("Email invalido!")
                    }
                }else{
                    showToast("Informe um email")
                }
                if (!senha.isEmpty()){
                    if(isPasswordValid(senha)){
                        showToast("Senha valida!")
                    }else{
                        showToast("Senha inválida!" +
                                "A senha deve conter 8 caracteres" +
                                "A senha deve conter no minimo uma letra minuscula" +
                                "A senha deve conter no minimo uma letra maiuscula" +
                                "A senha deve conter um carater especial (#$@%...)")
                    }
                }else{
                    showToast("Informe uma senha")
                }
                if (!number.isEmpty()){
                    if (isNumberValid(number)){
                        showToast("Numero válido!")
                    }else{
                        showToast("Número inválido!")
                    }
                }else{
                    showToast("Informe um numero")
                }
            }
        }
    }

    private fun isNumberValid(number: String): Boolean{
        val numberRegex = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}\$".toRegex()
        return numberRegex.matches(number)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        return email.matches(emailRegex)
    }

    private fun isPasswordValid(password: String) : Boolean {
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$".toRegex()
        return passwordRegex.matches(password)
    }
}