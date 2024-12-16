package com.example.roomlocaldbtugas9.ui.viewmodel


import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomlocaldbtugas9.data.entity.Mahasiswa
import com.example.roomlocaldbtugas9.repository.RepositoryMhs
import com.example.roomlocaldbtugas9.ui.navigation.DestinasiDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


    fun deleteMhs() {
        detailUiState.value.detailUiEvent.toMahasiswaEntity().let{
            viewModelScope.launch{
                repositoryMhs.deleteMhs(it)
            }
        }
    }
}



data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError : Boolean = false,
    val errorMessage: String = ""
) {
    val isUiEventEmpty : Boolean
        get() = detailUiEvent == MahasiswaEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MahasiswaEvent()
}
fun Mahasiswa.toDetailUiEvent() : MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}