package com.example.roomlocaldbtugas9.ui.viewmodel

class UpdateMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs: RepositoryMhs
) : ViewModel(){
    var updateUIState by mutableStateOf(MhsUIState())
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init{
        viewModelScope.launch{
            updateUIState = repositoryMhs.getMhs(_nim)
                .filterNotNull()
                .first()
                .toUIStateMhs()
        }
    }
    fun updateState(mahasiswaEvent: MahasiswaEvent) {
        updateUIState = updateUIState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }
    fun validateFields() : Boolean{
        val event = updateUIState.mahasiswaEvent
        val errorState = FormErrrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",
            kelas = if (event.kelas.isNotEmpty()) null else "Kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isNotEmpty()) null else "Angkatan tidak boleh kosong",
        )
        updateUIState = updateUIState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
