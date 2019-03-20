package com.edu.appswbd.practica.cuatro.mysql.services.impl;

import com.edu.appswbd.practica.cuatro.mysql.components.CompanyStatusConverter;
import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyStatusModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.CompanyStatusRepository;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class CompanyStatusServiceImpl implements CompanyStatusService {

    @Autowired
    @Qualifier("companyDetailRepository")
    private CompanyStatusRepository companyStatusRepository;

    @Autowired
    @Qualifier("companyDetailConverter")
    private CompanyStatusConverter companyStatusConverter;

    @Override
    public CompanyStatusModel addCompanyStatus(CompanyStatusModel companyStatusModel) {
        CompanyStatus temp = companyStatusConverter.convertCompanyStatusModel2CompanyStatus(companyStatusModel);
        CompanyStatus companyStatus = companyStatusRepository.save(temp);
        return companyStatusConverter.convertCompanyStatus2CompanyStatusModel(companyStatus);
    }

    @Override
    public List<CompanyStatusModel> listAllCompanyStatus() {
        List<CompanyStatus> companyStatuses = companyStatusRepository.findAll();
        List<CompanyStatusModel> companyStatusModel = new ArrayList();
        for(CompanyStatus companyStatus : companyStatuses)
            companyStatusModel.add(companyStatusConverter.convertCompanyStatus2CompanyStatusModel(companyStatus));
        return companyStatusModel;
    }

    @Override
    public CompanyStatus findCompanyStatusById(int id) {
        return companyStatusRepository.findById(id);
    }

    public CompanyStatusModel findCompanyStatusByIdModel(int id) {
        return companyStatusConverter.convertCompanyStatus2CompanyStatusModel(findCompanyStatusById(id));
    }

    @Override
    public void removeCompanyStatus(int id) {
        CompanyStatus companyStatus = findCompanyStatusById(id);
        if(companyStatus != null)
            companyStatusRepository.delete(findCompanyStatusById(id));
    }
}
