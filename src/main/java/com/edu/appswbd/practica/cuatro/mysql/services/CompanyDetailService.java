package com.edu.appswbd.practica.cuatro.mysql.services;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyDetailModel;

import java.util.List;

public interface CompanyDetailService {
    public abstract CompanyDetailModel addCompanyDetail(CompanyDetailModel companyDetailModel);

    public abstract List<CompanyDetailModel> listAllCompanyDetails();

    public abstract CompanyDetail findCompanyDetailById(int id);

    public abstract void removeCompanyDetail(int id);

    public abstract CompanyDetailModel findCompanyDetailByIdModel(int id);

}
