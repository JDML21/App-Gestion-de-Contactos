package com.example.aplicacion.Presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class ContactListViewModel(private val repository: ContactRepository) : ViewModel() {

    val contacts: List<Contact>
        get() = repository.getContacts()
}