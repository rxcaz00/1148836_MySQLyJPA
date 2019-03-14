package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(mappedBy = "contact")
    private List<ContactDetail> contactDetailListList;

    public Contact(int id, String firstname, String lastname, String telephone, String email, Date version, Company company) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.version = version;
        this.company = company;
    }
}
