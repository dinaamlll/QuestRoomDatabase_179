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
