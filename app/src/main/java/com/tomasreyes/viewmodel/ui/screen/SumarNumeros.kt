package com.tomasreyes.viewmodel.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tomasreyes.viewmodel.SumaViewModel

@Composable
fun SumaScreen(
    modifier: Modifier = Modifier,
    viewModel: SumaViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Suma de dos números",
            style = MaterialTheme.typography.headlineMedium
        )
        OutlinedTextField(
            value = viewModel.n1,
            onValueChange = { viewModel.onN1Changed(it) },
            label = { Text("Ingresa el primer número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = viewModel.n2,
            onValueChange = { viewModel.onN2Changed(it) },
            label = { Text("Ingresa el segundo número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = { viewModel.calcularSuma() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Suma")
        }

        if (viewModel.resultado.isNotEmpty()) {
            Text(
                text = "Resultado: ${viewModel.resultado}",
                style = MaterialTheme.typography.titleLarge
            )
        }

    }
}