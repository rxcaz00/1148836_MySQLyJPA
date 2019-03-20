package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import lombok.Data;

import java.util.Date;

@Data
public class ContactDetailModel {
    private int id;
    private int gender;
    private Date dateOfBirth;
    private Contact contact;

    public ContactDetailModel(int id, int gender, Date dateOfBirth, Contact contact) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }

    public ContactDetailModel() {

    }
}
