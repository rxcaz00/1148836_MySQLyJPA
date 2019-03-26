package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.CompanyStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component("companyConverter")
public class CompanyConverter {

    @Autowired
    @Qualifier("companyStatusRepository")
    private CompanyStatusRepository companyStatusRepository;

    public Company convertCompanyModel2Company(CompanyModel companyModel) {
        Company company = new Company();
        List<CompanyStatus> companyStatuses = companyStatusRepository.findAll();
        for(CompanyStatus companyStatus : companyStatuses)
            if(companyStatus.getName().equals(companyModel.getCompanyStatus())) {
                company.setCompanyStatus(companyStatus);
                break;
            }
        company.setContactList(companyModel.getContactList());
        company.setId(companyModel.getId());
        company.setName(companyModel.getName());
        try {
            String[] dates = companyModel.getVersion().split("T");
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dates[0] + " " + dates[1]);
            company.setVersion(date);
        } catch (Exception e) {

        }
        return company;
    }

    public CompanyModel convertCompany2CompanyModel(Company company) {
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyStatus(company.getCompanyStatus().getName());
        companyModel.setContactList(company.getContactList());
        companyModel.setId(company.getId());
        companyModel.setName(company.getName());
        companyModel.setVersion(company.getVersion().toString());
        return companyModel;
    }
}
