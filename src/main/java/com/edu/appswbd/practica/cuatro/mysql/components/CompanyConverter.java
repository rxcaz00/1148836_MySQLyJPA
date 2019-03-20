package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyModel;
import org.springframework.stereotype.Component;

@Component("companyConverter")
public class CompanyConverter {
    public Company convertCompanyModel2Company(CompanyModel companyModel) {
        Company company = new Company();
        company.setCompanyStatus(companyModel.getCompanyStatus());
        company.setContactList(companyModel.getContactList());
        company.setId(companyModel.getId());
        company.setName(companyModel.getName());
        company.setVersion(companyModel.getVersion());
        return company;
    }

    public CompanyModel convertCompany2CompanyModel(Company company) {
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyStatus(company.getCompanyStatus());
        companyModel.setContactList(company.getContactList());
        companyModel.setId(company.getId());
        companyModel.setName(company.getName());
        companyModel.setVersion(company.getVersion());
        return companyModel;
    }
}
