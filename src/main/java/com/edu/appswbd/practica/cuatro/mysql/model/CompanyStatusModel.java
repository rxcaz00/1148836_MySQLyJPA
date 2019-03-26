package com.edu.appswbd.practica.cuatro.mysql.model;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CompanyStatusModel {
    private int id;
    private String name;
    //private Set<Company> companyList = new HashSet<Company>();
    private List<Company> companyList = new ArrayList<Company>();

    public CompanyStatusModel() {

    }
}
