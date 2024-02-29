package com.example.aplicacion.domain

import com.example.aplicacion.data.model.Contact
import com.example.aplicacion.data.repository.ContactRepository

class GetContactUse(private val repository: ContactRepository) {

    fun execute(contactId: Int): Contact? {
        return repository.getContactById(contactId)
    }
}