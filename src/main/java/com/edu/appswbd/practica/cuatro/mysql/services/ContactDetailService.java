package com.edu.appswbd.practica.cuatro.mysql.services;

import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactDetailModel;

import java.util.List;

public interface ContactDetailService {
    public abstract ContactDetailModel addContactDetail(ContactDetailModel contactDetailModel) throws Exception;

    public abstract List<ContactDetailModel> listAllContactDetails();

    public abstract ContactDetail findContactDetailById(int id);

    public abstract void removeContactDetail(int id);

    public abstract ContactDetailModel findContactDetailByIdModel(int id);
}
