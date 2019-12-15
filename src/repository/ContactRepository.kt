package repository

import entity.ContactEntity

class ContactRepository (){

    companion object{
        private var contactList = mutableListOf<ContactEntity>()
        fun saveContact(contactEntity: ContactEntity){
            contactList.add(contactEntity)
        }

        fun deleteContact(contactEntity: ContactEntity){
            var index = 0
            for (item in contactList.withIndex()){
                if (item.value.name == contactEntity.name && item.value.telephone == contactEntity.telephone){
                    index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        fun getContactList() : List<ContactEntity>{
            return contactList
        }
    }
}