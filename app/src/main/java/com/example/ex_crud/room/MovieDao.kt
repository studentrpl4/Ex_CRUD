package com.example.ex_crud.room

import androidx.room.*

@Dao
interface MovieDao {

    @Insert
    suspend fun addmovie(movie: Movie)

    @Update
    suspend fun updatemovie(movie: Movie)

    @Delete
    suspend fun deletemovie(movie: Movie)

    @Query("SELECT * FROM movie")
    suspend fun getmovie():List<Movie>
}