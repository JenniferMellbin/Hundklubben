
package com.example.hundklubben.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = SoftPurple,
    onPrimary = Color.White,
    secondary = Peach,
    onSecondary = DeepPurple,
    tertiary = SoftPeach,
    background = Lavender,
    onBackground = DeepPurple,
    surface = CreamWhite,
    onSurface = DeepPurple
)

@Composable
fun HundklubbenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
