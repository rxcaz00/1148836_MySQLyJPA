package com.edu.appswbd.practica.cuatro.mysql.services.impl;

import com.edu.appswbd.practica.cuatro.mysql.components.CompanyConverter;
import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.CompanyRepository;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("companyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier("companyConverter")
    private CompanyConverter companyConverter;

    @Override
    public CompanyModel addCompany(CompanyModel companyModel) {
        Company temp = companyConverter.convertCompanyModel2Company(companyModel);
        Company company = companyRepository.save(temp);
        return companyConverter.convertCompany2CompanyModel(company);
    }

    public List<CompanyModel> listAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyModel> companiesModel = new ArrayList();
        for(Company company : companies)
            companiesModel.add(companyConverter.convertCompany2CompanyModel(company));
        return companiesModel;
    }

    @Override
    public Company findCompanyById(int id) { return companyRepository.findById(id); }

    public CompanyModel findCompanyByIdModel(int id) {
        return companyConverter.convertCompany2CompanyModel(findCompanyById(id));
    }

    @Override
    public void removeCompany(int id) {
        Company company = findCompanyById(id);
        if(company != null)
            companyRepository.delete(findCompanyById(id));
    }
}
