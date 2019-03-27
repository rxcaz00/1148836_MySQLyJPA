package com.edu.appswbd.practica.cuatro.mysql.services;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyModel;

import java.util.List;

public interface CompanyService {
    public abstract CompanyModel addCompany(CompanyModel companyModel) throws Exception;

    public abstract List<CompanyModel> listAllCompanies();

    public abstract Company findCompanyById(int id);

    public abstract void removeCompany(int id);

    public abstract CompanyModel findCompanyByIdModel(int id);
}
