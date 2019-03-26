package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import lombok.Data;

import java.util.Date;

@Data
public class ContactDetailModel {
    private int id;
    private int gender;
    private String dateOfBirth;
    private String contact;

    public ContactDetailModel() {

    }
}
