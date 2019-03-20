package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyStatusModel;
import org.springframework.stereotype.Component;

@Component("companyStatusConverter")
public class CompanyStatusConverter {
    public CompanyStatus convertCompanyStatusModel2CompanyStatus(CompanyStatusModel companyStatusModel) {
        CompanyStatus companyStatus = new CompanyStatus();
        companyStatus.setCompanyList(companyStatusModel.getCompanyList());
        companyStatus.setId(companyStatusModel.getId());
        companyStatus.setName(companyStatusModel.getName());
        return companyStatus;
    }

    public CompanyStatusModel convertCompanyStatus2CompanyStatusModel(CompanyStatus companyStatus) {
        CompanyStatusModel companyStatusModel = new CompanyStatusModel();
        companyStatusModel.setCompanyList(companyStatus.getCompanyList());
        companyStatusModel.setId(companyStatus.getId());
        companyStatusModel.setName(companyStatus.getName());
        return companyStatusModel;
    }
}
