package com.edu.appswbd.practica.cuatro.mysql.model;

import lombok.Data;

@Data
public class CompanyDetailModel {
    private int id;
    private int employeeStrength;
    private String notes;

    public CompanyDetailModel() {

    }
}
