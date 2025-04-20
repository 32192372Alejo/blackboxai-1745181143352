package com.example.coupleapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class GalleryActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var pageIndicatorContainer: LinearLayout
    private val memories = Memory.getMemories()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // Inicializar ViewPager2
        viewPager = findViewById(R.id.viewPager)
        pageIndicatorContainer = findViewById(R.id.pageIndicator)

        // Configurar el adaptador
        val adapter = MemoryAdapter(memories)
        viewPager.adapter = adapter

        // Crear indicadores de página
        setupPageIndicators()

        // Configurar el listener para actualizar los indicadores
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updatePageIndicators(position)
            }
        })
    }

    private fun setupPageIndicators() {
        val indicators = Array(memories.size) { ImageView(this) }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(8, 0, 8, 0)
        }

        indicators.forEach { indicator ->
            indicator.setImageDrawable(
                ContextCompat.getDrawable(this, android.R.drawable.presence_invisible)
            )
            indicator.layoutParams = params
            pageIndicatorContainer.addView(indicator)
        }

        // Establecer el primer indicador como activo
        indicators[0].setImageDrawable(
            ContextCompat.getDrawable(this, android.R.drawable.presence_online)
        )
    }

    private fun updatePageIndicators(position: Int) {
        for (i in 0 until pageIndicatorContainer.childCount) {
            val indicator = pageIndicatorContainer.getChildAt(i) as ImageView
            indicator.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    if (i == position) android.R.drawable.presence_online
                    else android.R.drawable.presence_invisible
                )
            )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Agregar animación de transición al cerrar
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
