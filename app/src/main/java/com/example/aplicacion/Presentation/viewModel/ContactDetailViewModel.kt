package com.example.aplicacion.Presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class ContactDetailViewModel(private val repository: ContactRepository) : ViewModel() {

    fun getContactById(contactId: Int): Contact? {
        return repository.getContactById(contactId)
    }

    fun deleteContact(contactId: Int) {
        repository.deleteContact(contactId)
    }
}