package com.edu.appswbd.practica.cuatro.mysql.services;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyStatusModel;

import java.util.List;

public interface CompanyStatusService {
    public abstract CompanyStatusModel addCompanyStatus(CompanyStatusModel companyStatusModel);

    public abstract List<CompanyStatusModel> listAllContacts();

    public abstract CompanyStatus findCompanyStatusById(int id);

    public abstract void removeCompanyStatus(int id);

    public abstract CompanyStatusModel findCompanyStatusByIdModel(int id);
}
