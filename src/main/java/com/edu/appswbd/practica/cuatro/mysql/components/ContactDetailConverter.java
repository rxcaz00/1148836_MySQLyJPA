package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactDetailModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component("contactDetailConverter")
public class ContactDetailConverter {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    public ContactDetail convertContactDetailModel2ContactDetail(ContactDetailModel contactDetailModel) {
        ContactDetail contactDetail = new ContactDetail();
        List<Contact> contacts = contactRepository.findAll();
        for(Contact contact : contacts)
            if(contact.getTelephone().equals(contactDetailModel.getContact())) {
                contactDetail.setContact(contact);
                break;
            }
        try {
            String[] dates = contactDetailModel.getDateOfBirth().split("T");
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dates[0] + " " + dates[1]);
            contactDetail.setDateOfBirth(date);
        } catch (Exception e) {

        }
        contactDetail.setGender(contactDetailModel.getGender());
        contactDetail.setId(contactDetailModel.getId());
        return contactDetail;
    }

    public ContactDetailModel convertContactDetail2ContactDetailModel(ContactDetail contactDetail) {
        ContactDetailModel contactDetailModel = new ContactDetailModel();
        contactDetailModel.setContact(contactDetail.getContact().getFirstname() + " " + contactDetail.getContact().getLastname());
        contactDetailModel.setDateOfBirth(contactDetail.getDateOfBirth().toString());
        contactDetailModel.setGender(contactDetail.getGender());
        contactDetailModel.setId(contactDetail.getId());
        return contactDetailModel;
    }
}
