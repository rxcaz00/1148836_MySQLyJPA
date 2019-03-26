package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "companystatus")
public class CompanyStatus {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "companyStatus")
    //private Set<Company> companyList = new HashSet<Company>();
    private List<Company> companyList = new ArrayList<Company>();

    public CompanyStatus() {

    }
}
