package com.example.hundklubben

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hundklubben.ui.theme.HundklubbenTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.ui.Alignment
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HundklubbenTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFD8C8),
                                    Color(0xFFF4DCEB),
                                    Color(0xFFE9DDF7)
                                )
                            )
                        )
                ) {     Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            containerColor = Color.Transparent,
                            topBar = {
                                TopAppBar(
                                    title = {
                                        Text("🐾 Hundklubben")
                                    },
                                    colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = Color.Transparent
                                    )
                                )
                            }
                        ) { innerPadding ->
                            Greeting(
                                name = "Hundklubben",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {

        val viewModel = remember { HundklubbenViewModel() }
        var aktivitetNamn by remember { mutableStateOf("") }
        var valdKategori by remember { mutableStateOf("Träning") }
        var redigerarId by remember { mutableStateOf<Int?>(null) }
        var valtFilter by remember { mutableStateOf("Alla") }
        val snackbarHostState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()
        //snackbarHostState håller reda på meddelandet som ska visas längst ner i appen
        //coroutineScope gör att vi kan visa meddelandet utan att låsa gränssnittet
        // medan vi väntar på att användaren eventuellt trycker på Ångra.

        Box(
            modifier = modifier.fillMaxSize()
        ) {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "Välkommen till $name!",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = aktivitetNamn,
                    onValueChange = { aktivitetNamn = it },
                    label = { Text("Aktivitetens namn") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text("Välj kategori:")

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Träning", "Tävling", "Kurs").forEach { kategori ->

                        if (valdKategori == kategori) {
                            Button(
                                onClick = { valdKategori = kategori }
                            ) {
                                Text(kategori)
                            }
                        } else {
                            OutlinedButton(
                                onClick = { valdKategori = kategori }
                            ) {
                                Text(kategori)
                            }
                        }
                    }
                }

                Button(
                    onClick = {
                        if (aktivitetNamn.isNotBlank()) {

                            if (redigerarId != null) {
                                viewModel.redigeraAktivitet(
                                    redigerarId!!,
                                    aktivitetNamn,
                                    valdKategori
                                )
                                redigerarId = null
                            } else {
                                viewModel.laggTillAktivitet(
                                    aktivitetNamn,
                                    valdKategori
                                )
                            }

                            aktivitetNamn = ""
                        }
                    }
                ) {
                    Text(
                        if (redigerarId != null) "Spara ändringar"
                        else "Lägg till aktivitet"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text("Filtrera aktiviteter:")

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Alla", "Ej klara", "Klara").forEach { filter ->

                        if (valtFilter == filter) {
                            Button(
                                onClick = { valtFilter = filter }
                            ) {
                                Text(filter)
                            }
                        } else {
                            OutlinedButton(
                                onClick = { valtFilter = filter }
                            ) {
                                Text(filter)
                            }
                        }
                    }
                }
                val totalt = viewModel.aktiviteter.size
                val genomforda = viewModel.aktiviteter.count { it.genomford }

                Text(
                    text = "$genomforda av $totalt aktiviteter genomförda"
                )

                Spacer(modifier = Modifier.height(10.dp))

                if (viewModel.aktiviteter.isEmpty()) {
                    Text(
                        text = "Du har inga aktiviteter ännu. Lägg till din första aktivitet! 🐾"
                    )
                }
                val filtreradeAktiviteter = when (valtFilter) {
                    "Ej klara" -> viewModel.aktiviteter.filter { !it.genomford }
                    "Klara" -> viewModel.aktiviteter.filter { it.genomford }
                    else -> viewModel.aktiviteter
                }
                LazyColumn {

                    items(
                        items = filtreradeAktiviteter,
                        key = { it.id }
                    ) { aktivitet ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFAF8)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = aktivitet.genomford,
                                    onCheckedChange = {
                                        viewModel.andraStatus(aktivitet.id)
                                    }
                                )

                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = aktivitet.namn,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF654B86)
                                    )

                                    Text(
                                        text = aktivitet.kategori,
                                        color = Color(0xFF9673C4),
                                        fontSize = 12.sp
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        redigerarId = aktivitet.id
                                        aktivitetNamn = aktivitet.namn
                                        valdKategori = aktivitet.kategori
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Redigera aktivitet",
                                        tint = Color(0xFF9673C4)
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        val borttagenAktivitet = aktivitet

                                        viewModel.taBortAktivitet(aktivitet.id)

                                        coroutineScope.launch {
                                            val resultat = snackbarHostState.showSnackbar(
                                                message = "Aktiviteten har tagits bort",
                                                actionLabel = "Ångra",
                                                withDismissAction = true
                                            )

                                            if (resultat == SnackbarResult.ActionPerformed) {
                                                viewModel.aterstallAktivitet(borttagenAktivitet)
                                            }
                                        }
                                    }
                                ) {


                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Ta bort aktivitet",
                                        tint = Color(0xFF9673C4)
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }

@Preview(showBackground = true)

                    @Composable

                    fun GreetingPreview() {
                        HundklubbenTheme {
                            Greeting("Android")
                        }
                    }




