package com.example.roomlocaldbtugas9

import android.app.Application
import com.example.roomlocaldbtugas9.dependenciesinjection.ContainerApp
import com.example.roomlocaldbtugas9.dependenciesinjection.InterfaceContainerApp

class KrsApp: Application() {
    lateinit var containerApp: ContainerApp // Fungsinya untuk menyimpan
    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) // membuat instance
        //instance adalah object yang dibuat dari class
    }
}