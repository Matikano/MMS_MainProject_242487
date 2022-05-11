package pl.edu.pwr.lab4.i242487.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

abstract class ModuleModel(
    val name: String,
    val description: String,
    val address: String,
    val latLong: Pair<Double, Double>,
    val images: List<String>
) : Serializable
