package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "companyStatus")
    private List<Company> companyList;

    public CompanyStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
