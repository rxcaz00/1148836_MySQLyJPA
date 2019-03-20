package com.edu.appswbd.practica.cuatro.mysql.services.impl;

import com.edu.appswbd.practica.cuatro.mysql.components.ContactConverter;
import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.ContactRepository;
import com.edu.appswbd.practica.cuatro.mysql.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el contactModel a entidad
        Contact temp=contactConverter.convertContactModel2Contact(contactModel);
        Contact contact = contactRepository.save(temp);
        return contactConverter.convertContact2ContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList();
        for(Contact contact : contacts){
            contactsModel.add(contactConverter.convertContact2ContactModel(contact));

        }
        return contactsModel;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    public ContactModel findContactByIdModel(int id){
        return contactConverter.convertContact2ContactModel(findContactById(id));
    }

    @Override
    public void removeContact(int id) {
        Contact contact  = findContactById(id);
        if(contact != null){
            contactRepository.delete(findContactById(id));
        }
    }


}
