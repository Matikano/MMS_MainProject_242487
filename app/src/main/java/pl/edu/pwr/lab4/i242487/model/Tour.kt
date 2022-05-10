package pl.edu.pwr.lab4.i242487.model

data class Tour(
    val name: String,
    val description: String,
    val places: List<Pair<Double, Double>>,
    val images: List<String>
)
