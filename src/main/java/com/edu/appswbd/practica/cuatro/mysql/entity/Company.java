package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private Date version;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId")
    private CompanyStatus companyStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    //private Set<Contact> contactList = new HashSet<Contact>();
    private List<Contact> contactList = new ArrayList<Contact>();

    public Company() {

    }
}
