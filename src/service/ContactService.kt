package service

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

class ContactService {

    companion object{
        fun validate(contactEntity: ContactEntity) {
            if (contactEntity.name == "")
                throw Exception("Error name is empty!")
            if (contactEntity.telephone == "")
                throw Exception("Error telephone is empty!")
        }

        fun validateDelete(contactEntity: ContactEntity) {
            if (contactEntity.name == "" || contactEntity.telephone == "")
                throw Exception("Error select one contact!")
        }

        fun saveContact(contactEntity: ContactEntity) {
            ContactRepository.saveContact(contactEntity)
        }

        fun deleteContact(contactEntity: ContactEntity) {
            ContactRepository.deleteContact(contactEntity)
        }

        fun getContactList(): List<ContactEntity> {
            return ContactRepository.getContactList()
        }

        fun getCountTable() :String{
            var contactList = getContactList()

            return when (contactList.size) {
                0 -> "The list is empty"
                1 -> "1 contact"
                else -> "${contactList.size} contacts"
            }
        }
    }
}