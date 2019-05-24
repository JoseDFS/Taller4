package com.example.taller_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller_4.R
import com.example.taller_4.Constants
import kotlinx.android.synthetic.main.activity_book.*

class Activity_Libro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val intento = intent
        if(intento != null){
            tv_caratula.text = intento.getStringExtra(Constants.TEXT_KEY_CARATULA)
            tv_title_book_activity.text = intento.getStringExtra(Constants.TEXT_KEY_TITULO)
            tv_autores.text = intento.getStringExtra(Constants.TEXT_KEY_AUTORES)
            tv_edicion.text = intento.getStringExtra(Constants.TEXT_KEY_EDICION)
            tv_editoriales.text = intento.getStringExtra(Constants.TEXT_KEY_EDITORIAL)
            tv_isbn.text = intento.getStringExtra(Constants.TEXT_KEY_ISBN)
            tv_resumen.text = intento.getStringExtra(Constants.TEXT_KEY_RESUMEN)
            tv_tag.text = intento.getStringExtra(Constants.TEXT_KEY_TAG)
        }
    }


}