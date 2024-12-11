package com.example.roomlocaldbtugas9.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.roomlocaldbtugas9.data.entity.Mahasiswa

@Dao //Dao buat DML
interface MahasiswaDao {
    @Insert
    suspend fun  insertMahasiswa(mahasiswa: Mahasiswa)
}