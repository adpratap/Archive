package com.noreplypratap.archive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noreplypratap.domain.model.Archive
import com.noreplypratap.domain.usecase.CreateArchiveUseCase
import com.noreplypratap.domain.usecase.DeleteArchiveUseCase
import com.noreplypratap.domain.usecase.ReadArchiveUseCase
import com.noreplypratap.domain.usecase.UpdateArchiveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArchiveViewModel@Inject constructor(
    private val createArchiveUseCase: CreateArchiveUseCase,
    private val readArchiveUseCase: ReadArchiveUseCase,
    private val updateArchiveUseCase: UpdateArchiveUseCase,
    private val deleteArchiveUseCase: DeleteArchiveUseCase
): ViewModel() {

    init {
        readArchive()
    }

    private val _archive = MutableLiveData<List<Archive>>()
    val archive: LiveData<List<Archive>> get() = _archive

    fun createArchive(archive: Archive) {
        viewModelScope.launch(Dispatchers.IO) {
            createArchiveUseCase(archive)
        }
    }

    fun readArchive() = viewModelScope.launch(Dispatchers.IO) {
        readArchiveUseCase().collect {
            _archive.postValue(it)
        }
    }

    fun updateArchive(archive: Archive) {
        viewModelScope.launch(Dispatchers.IO) {
            updateArchiveUseCase(archive)
        }
    }

    fun deleteArchive(archive: Archive) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteArchiveUseCase(archive)
        }
    }

}