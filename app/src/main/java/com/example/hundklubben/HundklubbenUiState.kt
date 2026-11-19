package com.example.hundklubben

// Samlar information om appens aktuella tillstånd.
// Används för att hålla reda på aktiviteter, filter och statistik.
data class HundklubbenUiState(
    val aktiviteter: List<Aktivitet> = emptyList(),
    val valtFilter: String = "Alla",
    val antalGenomforda: Int = 0
)