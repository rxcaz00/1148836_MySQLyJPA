package com.edu.appswbd.practica.cuatro.mysql.services;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactModel;

import java.util.List;

public interface ContactService {
    public abstract ContactModel addContact(ContactModel contactModel) throws Exception;

    public abstract List<ContactModel> listAllContacts();

    public abstract Contact findContactById(int id);

    public abstract void removeContact(int id);

    public abstract ContactModel findContactByIdModel(int id);
}
