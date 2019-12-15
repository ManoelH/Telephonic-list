package repository

import entity.ContactEntity

class ContactRepository (){

    companion object{
        private var contactList = mutableListOf<ContactEntity>()
        fun saveContact(contactEntity: ContactEntity){
            contactList.add(contactEntity)
        }

        fun deleteContact(contactEntity: ContactEntity){
            contactList.remove(contactEntity)
        }

        fun getContactList() : List<ContactEntity>{
            return contactList
        }
    }
}