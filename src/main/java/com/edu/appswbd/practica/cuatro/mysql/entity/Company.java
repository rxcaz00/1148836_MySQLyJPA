package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "statusId")
    private CompanyStatus companyStatus;

    @OneToMany(mappedBy = "company")
    private List<Contact> contactList;

    public Company(int id, String name, Date version, CompanyStatus companyStatus) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.companyStatus = companyStatus;
    }
}
