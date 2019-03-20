package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompanyModel {
    private int id;
    private String name;
    private Date version;
    private CompanyStatus companyStatus;
    private List<Contact> contactList;

    public CompanyModel(int id, String name, Date version, CompanyStatus companyStatus) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.companyStatus = companyStatus;
    }

    public CompanyModel() {

    }
}
