package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CompanyModel {
    private int id;
    private String name;
    private String version;
    private String companyStatus;
    //private Set<Contact> contactList = new HashSet<Contact>();
    private List<Contact> contactList = new ArrayList<Contact>();

    public CompanyModel() {

    }
}
