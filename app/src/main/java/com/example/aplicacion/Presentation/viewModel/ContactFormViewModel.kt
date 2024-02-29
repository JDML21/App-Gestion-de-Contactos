package com.example.aplicacion.Presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class ContactFormViewModel(private val repository: ContactRepository) : ViewModel() {

    fun saveContact(contact: Contact) {
        repository.saveContact(contact)
    }

    fun updateContact(contact: Contact) {
        repository.updateContact(contact)
    }
}