package com.example.hundklubben

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class HundklubbenViewModel : ViewModel() {
    val aktiviteter = mutableStateListOf<Aktivitet>()
    fun laggTillAktivitet(namn: String, kategori: String) {
        if (namn.isBlank()) return

        val nyAktivitet = Aktivitet(
            id = (aktiviteter.maxOfOrNull { it.id } ?: 0) + 1,
            namn = namn.trim(),
            kategori = kategori
        )

        aktiviteter.add(nyAktivitet)
    }
}