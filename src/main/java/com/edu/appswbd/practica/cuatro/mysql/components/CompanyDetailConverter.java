package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyDetailModel;
import org.springframework.stereotype.Component;

@Component("companyDetailConverter")
public class CompanyDetailConverter {
    public CompanyDetail convertCompanyDetailModel2CompanyDetail(CompanyDetailModel companyDetailModel) {
        CompanyDetail companyDetail = new CompanyDetail();
        companyDetail.setEmployeeStrength(companyDetailModel.getEmployeeStrength());
        companyDetail.setId(companyDetailModel.getId());
        companyDetail.setNotes(companyDetailModel.getNotes());
        return companyDetail;
    }

    public CompanyDetailModel convertCompanyDetail2CompanyDetailModel(CompanyDetail companyDetail) {
        CompanyDetailModel companyDetailModel = new CompanyDetailModel();
        companyDetailModel.setEmployeeStrength(companyDetail.getEmployeeStrength());
        companyDetailModel.setId(companyDetail.getId());
        companyDetailModel.setNotes(companyDetail.getNotes());
        return companyDetailModel;
    }
}
