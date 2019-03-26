package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ContactModel {
    private int id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String email;
    private String version;
    private String company;
    //private Set<ContactDetail> contactDetailList = new HashSet<ContactDetail>();
    private List<ContactDetail> contactDetailList = new ArrayList<ContactDetail>();

    public ContactModel() {

    }
}
