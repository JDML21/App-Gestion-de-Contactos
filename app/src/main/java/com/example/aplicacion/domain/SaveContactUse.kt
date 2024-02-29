package com.example.aplicacion.domain

import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class SaveContactUse(private val repository: ContactRepository) {

    fun execute(contact: Contact) {
        repository.saveContact(contact)
    }
}