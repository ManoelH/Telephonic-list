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
                throw Exception("Error select one number!")
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
    }
}