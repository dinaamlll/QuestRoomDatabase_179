package com.example.roomlocaldbtugas9.repository

import com.example.roomlocaldbtugas9.data.entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}