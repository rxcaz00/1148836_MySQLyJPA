package com.edu.appswbd.practica.cuatro.mysql.model;

import lombok.Data;

@Data
public class CompanyDetailModel {
    private int id;
    private int employeeStrength;
    private String notes;

    public CompanyDetailModel(int id, int employeeStrength, String notes) {
        this.id = id;
        this.employeeStrength = employeeStrength;
        this.notes = notes;
    }

    public CompanyDetailModel() {

    }
}
