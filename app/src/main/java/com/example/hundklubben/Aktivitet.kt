package com.example.hundklubben

data class Aktivitet(
    val id: Int,
    val namn: String,
    val kategori: String,
    val genomford: Boolean = false
)