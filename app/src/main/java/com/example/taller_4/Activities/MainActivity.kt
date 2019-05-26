package com.example.taller_4.Activities



import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller_4.Fragments.BookFragment
import com.example.taller_4.Fragments.FavoriteFragment
import com.example.taller_4.Fragments.MainFragment
import com.example.taller_4.R

class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener, FavoriteFragment.OnFragmentInteractionListener, BookFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mainFragment: MainFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)


        mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_content, mainFragment).commit()


    }
}
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val word = Book(
                        data.getStringExtra(NewBookActivity.TITULO),
                        data.getStringExtra(NewBookActivity.AUTOR),
                        data.getStringExtra(NewBookActivity.EDITORIAL),
                        data.getStringExtra(NewBookActivity.RESUMEN),
                        data.getBooleanExtra(NewBookActivity.FAVORITO)
                )
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
            ).show()
        }
    }
}

private fun Intent.getBooleanExtra(favorito: String): Boolean {
    return favorito.toBoolean()
}*/
