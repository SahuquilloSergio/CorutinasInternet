package com.pmdm.sauky.pruebainternet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    val LOGTAG = "requestwp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{peticionwp()}


    }

    fun peticionwp() {
        var respuesta = ""
        // lanza la corutina NO en el hilo principal
        doAsync{
            // peticion a wordpress CAMBIAR DIRECCION
            respuesta = URL("http://52.15.150.230/wp5/?rest_route=/wp/v2/posts/1").readText()
            // Accedemos al hilo principal
            uiThread {
                response.text = respuesta
                Log.d(LOGTAG, respuesta)
                longToast("Request performed")
            }
        }
    }
    }

