package com.example.aplicacion.domain

import com.example.aplicacion.data.repository.ContactRepository

class DeleteContactUse(private val repository: ContactRepository) {

    fun execute(contactId: Int) {
        repository.deleteContact(contactId)
    }
}