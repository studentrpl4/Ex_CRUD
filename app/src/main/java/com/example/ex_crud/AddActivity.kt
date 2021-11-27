package com.example.ex_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex_crud.room.Movie
import com.example.ex_crud.room.MovieDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    val db by lazy{ MovieDb(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupListener()
    }

    fun setupListener(){
        btn_save.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.movieDao().addmovie(
                    Movie(0, et_title.text.toString(),
                    et_desc.text.toString())
                )

                finish()
            }
        }
    }
}