package com.example.taller_4.Models

import com.example.taller_4.entities.Autor

data class Libro(
    val Caratula: String = "N/A",
    val Titulo: String = "N/A",
    val Autores: List<Autor> = emptyList(),
    val Edicion: Int = 0,
    val Editorial: String = "N/A",
    val ISBN: String = "N/A",
    val Resumen: String = "N/A",
    val Tag: List<String> = emptyList(),
    val Favorito: Boolean = false
)