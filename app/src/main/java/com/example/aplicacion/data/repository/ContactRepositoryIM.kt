package com.example.aplicacion.data.repository

import com.example.aplicacion.data.model.Contact
import java.io.*

class ContactRepositoryImpl(private val filePath: String) : ContactRepository {

    override fun getContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        try {
            val reader = BufferedReader(FileReader(filePath))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val contactInfo = line!!.split(",")
                val contact = Contact(
                    id = contactInfo[0].toInt(),
                    name = contactInfo[1],
                    phoneNumber = contactInfo[2],
                    email = contactInfo[3]
                )
                contacts.add(contact)
            }
            reader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return contacts
    }

    override fun getContactById(contactId: Int): Contact? {
        val contacts = getContacts()
        return contacts.find { it.id == contactId }
    }

    override fun saveContact(contact: Contact) {
        val file = File(filePath)
        try {
            val writer = BufferedWriter(FileWriter(file, true))
            writer.append("${contact.id},${contact.name},${contact.phoneNumber},${contact.email}\n")
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun updateContact(contact: Contact) {
        val contacts = getContacts()
        val updatedContacts = contacts.map {
            if (it.id == contact.id) contact else it
        }
        saveAllContacts(updatedContacts)
    }

    override fun deleteContact(contactId: Int) {
        val contacts = getContacts()
        val filteredContacts = contacts.filter { it.id != contactId }
        saveAllContacts(filteredContacts)
    }

    private fun saveAllContacts(contacts: List<Contact>) {
        val file = File(filePath)
        try {
            val writer = BufferedWriter(FileWriter(file))
            contacts.forEach { contact ->
                writer.append("${contact.id},${contact.name},${contact.phoneNumber},${contact.email}\n")
            }
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
