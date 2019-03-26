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
    private String version;
    private String company;
    private List<ContactDetail> contactDetailList;

    public ContactModel() {

    }
}
