package com.example.coupleapp

data class Memory(
    val imageUrl: String,
    val title: String,
    val description: String
) {
    companion object {
        fun getMemories() = listOf(
            Memory(
                "https://images.pexels.com/photos/1024969/pexels-photo-1024969.jpeg",
                "Nuestro Primer Encuentro",
                "El día que nuestros caminos se cruzaron..."
            ),
            Memory(
                "https://images.pexels.com/photos/1024988/pexels-photo-1024988.jpeg",
                "Momentos Especiales",
                "Cada momento contigo es único y especial..."
            ),
            Memory(
                "https://images.pexels.com/photos/1024993/pexels-photo-1024993.jpeg",
                "Aventuras Juntos",
                "Construyendo recuerdos inolvidables..."
            )
        )
    }
}
