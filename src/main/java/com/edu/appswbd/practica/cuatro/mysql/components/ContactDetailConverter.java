package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactDetailModel;
import org.springframework.stereotype.Component;

@Component("contactDetailConverter")
public class ContactDetailConverter {
    public ContactDetail convertContactDetailModel2ContactDetail(ContactDetailModel contactDetailModel) {
        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setContact(contactDetailModel.getContact());
        contactDetail.setDateOfBirth(contactDetailModel.getDateOfBirth());
        contactDetail.setGender(contactDetailModel.getGender());
        contactDetail.setId(contactDetailModel.getId());
        return contactDetail;
    }

    public ContactDetailModel convertContactDetail2ContactDetailModel(ContactDetail contactDetail) {
        ContactDetailModel contactDetailModel = new ContactDetailModel();
        contactDetailModel.setContact(contactDetail.getContact());
        contactDetailModel.setDateOfBirth(contactDetail.getDateOfBirth());
        contactDetailModel.setGender(contactDetail.getGender());
        contactDetailModel.setId(contactDetail.getId());
        return contactDetailModel;
    }
}
