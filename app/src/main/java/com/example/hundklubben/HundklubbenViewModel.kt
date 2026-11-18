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
    fun andraStatus(id: Int) {
        val index = aktiviteter.indexOfFirst { it.id == id }

        if (index != -1) {
            val aktivitet = aktiviteter[index]

            aktiviteter[index] = aktivitet.copy(
                genomford = !aktivitet.genomford
            )
        }
    }
    fun taBortAktivitet(id: Int) {
        aktiviteter.removeAll { it.id == id }
    }
    fun redigeraAktivitet(
        id: Int,
        nyttNamn: String,
        nyKategori: String
    ) {
        if (nyttNamn.isBlank()) return

        val index = aktiviteter.indexOfFirst { it.id == id }

        if (index != -1) {
            val aktivitet = aktiviteter[index]

            aktiviteter[index] = aktivitet.copy(
                namn = nyttNamn.trim(),
                kategori = nyKategori
            )
        }
    }
}