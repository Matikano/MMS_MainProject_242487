package pl.edu.pwr.lab4.i242487.utils.apiDirections

import android.net.Network
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

open class XMLParser() {

    protected lateinit var feedUrl: URL

    constructor(feedUrl: String): this(){
        try{
            this.feedUrl = URL(feedUrl)
        } catch (e : MalformedURLException){
            e.printStackTrace()
        }
    }

}