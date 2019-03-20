package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContactModel {
    private int id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String email;
    private Date version;
    private Company company;
    private List<ContactDetail> contactDetailList;

    public ContactModel(int id, String firstname, String lastname, String telephone, String email, Date version, Company company) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.version = version;
        this.company = company;
    }

    public ContactModel() {

    }
}
