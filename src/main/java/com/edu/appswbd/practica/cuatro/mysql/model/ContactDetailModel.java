package com.edu.appswbd.practica.cuatro.mysql.model;

import lombok.Data;

@Data
public class ContactDetailModel {
    private int id;
    private int gender;
    private String dateOfBirth;
    private String contact;

    public ContactDetailModel() {

    }
}
