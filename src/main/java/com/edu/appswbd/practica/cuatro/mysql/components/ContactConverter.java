package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {
    public Contact convertContactModel2Contact(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setCompany(contactModel.getCompany());
        contact.setEmail(contactModel.getEmail());
        contact.setFirstname(contactModel.getFirstname());
        contact.setId(contactModel.getId());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setVersion(contactModel.getVersion());
        contact.setContactDetailList(contactModel.getContactDetailList());
        return contact;
    }

    public ContactModel convertContact2ContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setCompany(contact.getCompany());
        contactModel.setEmail(contact.getEmail());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setId(contact.getId());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setVersion(contact.getVersion());
        contactModel.setContactDetailList(contact.getContactDetailList());
        return contactModel;
    }
}