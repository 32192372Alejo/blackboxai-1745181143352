package com.example.coupleapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar las vistas
        val titleText = findViewById<TextView>(R.id.titleText)
        val startButton = findViewById<Button>(R.id.startButton)

        // Aplicar animación de fade in al título
        titleText.startAnimation(
            AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
                duration = 1500
            }
        )

        // Configurar el botón para iniciar GalleryActivity
        startButton.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
