package controller

import entity.ContactEntity
import service.ContactService

class ContactController {

    private lateinit var contactEntity :ContactEntity

    fun saveContact(name :String, telephone :String){
        contactEntity = ContactEntity(name, telephone)
        ContactService.validate(contactEntity)
        ContactService.saveContact(contactEntity)
    }

    fun deleteContact(name :String, telephone :String){
        contactEntity = ContactEntity(name, telephone)
        ContactService.validateDelete(contactEntity)
        ContactService.deleteContact(contactEntity)
    }

    fun getContactList() : List<ContactEntity>{
        return ContactService.getContactList()
    }
}