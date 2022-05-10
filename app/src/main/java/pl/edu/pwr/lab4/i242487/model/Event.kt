package pl.edu.pwr.lab4.i242487.model

data class Event(
    val name: String,
    val description: String,
    val latLong: Pair<Double, Double>,
    val images: List<String>
)
