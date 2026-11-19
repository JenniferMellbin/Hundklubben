package com.example.hundklubben

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Delete


// Visar ett aktivitetskort med namn, kategori och kryssruta.
// Använder callbacks för att ändra status, redigera och ta bort.
// Själva ändringarna hanteras av resten av appen.
@Composable
fun AktivitetsKort(
    aktivitet: Aktivitet,
    onAndraStatus: () -> Unit,
    onRedigera: () -> Unit,
    onTaBort: () -> Unit
)
{
    // Skapar ett kort som fyller hela bredden
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Placerar kryssrutan och texten bredvid varandra
        Row {
            Checkbox(
                checked = aktivitet.genomford,
                onCheckedChange = { onAndraStatus() }
            )

            // Visar aktivitetens namn och kategori under varandra
            Column {
                Text(text = aktivitet.namn)
                Text(text = aktivitet.kategori)
            }
            // Knapp för att redigera aktiviteten
            IconButton( //skapar en klickbar knapp med en ikon.
                onClick = onRedigera
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Redigera aktivitet"
                )
            }
            // Knapp för att ta bort aktiviteten
            IconButton(
                onClick = onTaBort
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Ta bort aktivitet"
                )
            }
        }
    }
}