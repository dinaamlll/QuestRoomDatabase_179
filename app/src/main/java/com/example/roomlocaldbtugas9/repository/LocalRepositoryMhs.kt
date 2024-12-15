package com.example.roomlocaldbtugas9.repository

import com.example.roomlocaldbtugas9.data.dao.MahasiswaDao
import com.example.roomlocaldbtugas9.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMhs (
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
    //getAllMhs
    override fun getAllMhs() : Flow<List<Mahasiswa>>{
        return mahasiswaDao.getAllMahasiswa()
    }
    override fun getMhs(nim: String) : Flow<Mahasiswa>{
        return mahasiswaDao.getMhs(nim)
    }
    override suspend fun deleteMhs(mahasiswa: Mahasiswa){
        mahasiswaDao.deleteMhs(mahasiswa)
    }
    override suspend fun  updateMhs(mahasiswa:Mahasiswa){
        mahasiswaDao.updateMahasiswa(mahasiswa)
    }
}
