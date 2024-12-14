package com.example.roomlocaldbtugas9.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomlocaldbtugas9.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao //Dao buat DML
interface MahasiswaDao {
    @Insert
    suspend fun  insertMahasiswa(mahasiswa: Mahasiswa)
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>


}