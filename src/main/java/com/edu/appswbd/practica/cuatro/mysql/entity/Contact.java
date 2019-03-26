package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "version")
    private Date version;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contact")
    //private Set<ContactDetail> contactDetailList = new HashSet<ContactDetail>();
    private List<ContactDetail> contactDetailList = new ArrayList<ContactDetail>();

    public Contact(int id, String firstname, String lastname, String telephone, String email, Date version, Company company) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.version = version;
        this.company = company;
    }

    public Contact() {

    }
}
