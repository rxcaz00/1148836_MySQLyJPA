package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import lombok.Data;

import java.util.List;

@Data
public class CompanyStatusModel {
    private int id;
    private String name;
    private List<Company> companyList;

    public CompanyStatusModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyStatusModel() {

    }
}
