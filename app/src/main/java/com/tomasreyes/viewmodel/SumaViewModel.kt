package com.tomasreyes.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SumaViewModel: ViewModel() {

    var n1 by mutableStateOf("")
        private set

    var n2 by mutableStateOf("")
        private set

    var resultado by mutableStateOf("")
        private set

    fun onN1Changed(newValue: String) {
        n1 = newValue
    }

    fun onN2Changed(newValue: String) {
        n2 = newValue
    }

    fun calcularSuma() {
        val num1 = n1.toDoubleOrNull() ?: 0.0
        val num2 = n2.toDoubleOrNull() ?: 0.0
        val suma = num1 + num2

        resultado = if (suma % 1.0 == 0.0) {
            suma.toInt().toString()
        } else {
            suma.toString()
        }
    }
}
