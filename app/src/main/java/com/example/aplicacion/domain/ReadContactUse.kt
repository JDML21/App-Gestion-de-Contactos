package com.example.aplicacion.domain

import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class ReadContactUse(private val repository: ContactRepository) {

    fun execute(): List<Contact> {
        return repository.getContacts()
    }
}