package com.example.roomlocaldbtugas9.repository

import com.example.roomlocaldbtugas9.data.dao.MahasiswaDao
import com.example.roomlocaldbtugas9.data.entity.Mahasiswa

class LocalRepositoryMhs (
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa){
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
    }
