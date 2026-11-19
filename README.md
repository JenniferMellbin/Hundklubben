
# 🐾 Hundklubben

## Om appen

Hundklubben är en Androidapp som jag har utvecklat i Kotlin med Jetpack Compose som en del av min utbildning inom mobilapputveckling.

Appen hjälper hundägare att planera och hålla koll på aktiviteter som träning, tävlingar och kurser.

## Funktioner

- Lägga till nya aktiviteter med namn och kategori.
- Välja mellan kategorierna Träning, Tävling och Kurs.
- Markera aktiviteter som genomförda eller inte genomförda.
- Redigera och ta bort aktiviteter.
- Ångra borttagning av en aktivitet.
- Filtrera aktiviteter efter Alla, Ej klara och Klara.
- Se statistik över hur många aktiviteter som är genomförda.
- Visa ett meddelande när aktivitetslistan är tom.

## Teknik

Appen är utvecklad med:
- Kotlin
- Jetpack Compose
- Material 3
- ViewModel
- UiState
- Git och GitHub


## Problem och lösningar

Under utvecklingen stötte jag på flera problem som jag fick felsöka.

### Problem med filterhanteringen

När jag skulle flytta filterhanteringen från MainActivity till ViewModel fick jag röda fel i Android Studio.

Problemet var att jag först hade placerat koden för filtret inuti funktionen laggTillAktivitet(), i stället för direkt i klassen HundklubbenViewModel.

Jag löste problemet genom att flytta koden till rätt plats. Därefter ändrade jag filterknapparna så att de anropar funktionen andraFilter() i ViewModel.

Efter ändringarna testade jag filtreringen i emulatorn och kontrollerade att Alla, Ej klara och Klara fungerade.

Det här lärde mig mer om hur funktioner och variabler ska placeras i en klass och hur ViewModel och gränssnittet kommunicerar med varandra.


## Reflektion kring AI och hjälpmedel

Under utvecklingen av Hundklubben har jag använt ChatGPT som stöd för att förstå Kotlin och Jetpack Compose.

Jag har bland annat fått hjälp med att förstå hur ViewModel och UiState fungerar, hur jag kan dela upp gränssnittet i mindre Composable-funktioner och hur jag kan felsöka fel i Android Studio.

Jag har arbetat steg för steg, gjort ändringar i koden och testat funktionerna i emulatorn för att kontrollera att de fungerar.

En viktig sak jag har lärt mig är att AI-genererad kod inte alltid fungerar direkt. Jag behöver själv kontrollera var koden ska placeras, förstå vad den gör och testa resultatet.

Arbetet har gett mig bättre förståelse för hur en Androidapp byggs upp och hur gränssnittet kommunicerar med ViewModel.

Jag har också använt Android Studios felmeddelanden och emulator för att felsöka och testa appen.
