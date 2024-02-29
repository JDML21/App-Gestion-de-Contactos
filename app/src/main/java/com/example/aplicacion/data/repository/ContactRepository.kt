package com.example.aplicacion.data.repository

import com.example.aplicacion.data.model.Contact

interface ContactRepository {
    fun getContacts(): List<Contact>
    fun getContactById(contactId: Int): Contact?
    fun saveContact(contact: Contact)
    fun updateContact(contact: Contact)
    fun deleteContact(contactId: Int)
}