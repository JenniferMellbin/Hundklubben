package com.example.hundklubben

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf


class HundklubbenViewModel : ViewModel() {
    val aktiviteter = mutableStateListOf<Aktivitet>()
    // Håller reda på vilket filter användaren har valt
    var valtFilter = mutableStateOf("Alla")
        private set

    // Uppdaterar filtret när användaren väljer ett alternativ
    fun andraFilter(nyttFilter: String) {
        valtFilter.value = nyttFilter
    }

    // Samlar aktivitetslistan och statistiken i ett gemensamt UI-tillstånd.
// När aktivitetslistan ändras räknas värdena om.
    // Samlar informationen som gränssnittet behöver visa
    val uiState: HundklubbenUiState
        get() = HundklubbenUiState(
            aktiviteter = aktiviteter.toList(),
            valtFilter = valtFilter.value,
            antalGenomforda = aktiviteter.count { it.genomford }
        )
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
    fun aterstallAktivitet(aktivitet: Aktivitet) {
        if (aktiviteter.none { it.id == aktivitet.id }) {
            aktiviteter.add(aktivitet)
        }
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