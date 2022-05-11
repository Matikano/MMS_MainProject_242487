package pl.edu.pwr.lab4.i242487.model

class Event(name: String,
            description: String,
            address: String,
            latLong: Pair<Double, Double>,
            images: List<String>,
            ) : ModuleModel(name, description, address, latLong, images)
