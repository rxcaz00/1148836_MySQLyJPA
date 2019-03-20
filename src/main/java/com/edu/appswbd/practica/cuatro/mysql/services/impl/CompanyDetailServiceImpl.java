package com.edu.appswbd.practica.cuatro.mysql.services.impl;

import com.edu.appswbd.practica.cuatro.mysql.components.CompanyDetailConverter;
import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyDetailModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.CompanyDetailRepository;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("companyDetailServiceImpl")
public class CompanyDetailServiceImpl implements CompanyDetailService {

    @Autowired
    @Qualifier("companyDetailRepository")
    private CompanyDetailRepository companyDetailRepository;

    @Autowired
    @Qualifier("companyDetailConverter")
    private CompanyDetailConverter companyDetailConverter;

    @Override
    public CompanyDetailModel addCompanyDetail(CompanyDetailModel companyDetailModel) {
        CompanyDetail temp = companyDetailConverter.convertCompanyDetailModel2CompanyDetail(companyDetailModel);
        CompanyDetail companyDetail = companyDetailRepository.save(temp);
        return companyDetailConverter.convertCompanyDetail2CompanyDetailModel(companyDetail);
    }

    @Override
    public List<CompanyDetailModel> listAllCompanyDetails() {
        List<CompanyDetail> companyDetails = companyDetailRepository.findAll();
        List<CompanyDetailModel> companyDetailsModel = new ArrayList();
        for(CompanyDetail companyDetail : companyDetails)
            companyDetailsModel.add(companyDetailConverter.convertCompanyDetail2CompanyDetailModel(companyDetail));
        return companyDetailsModel;
    }

    @Override
    public CompanyDetail findCompanyDetailById(int id) {
        return companyDetailRepository.findById(id);
    }

    public CompanyDetailModel findCompanyDetailByIdModel(int id) {
        return companyDetailConverter.convertCompanyDetail2CompanyDetailModel(findCompanyDetailById(id));
    }

    @Override
    public void removeCompanyDetail(int id) {
        CompanyDetail companyDetail = findCompanyDetailById(id);
        if(companyDetail != null)
            companyDetailRepository.delete(findCompanyDetailById(id));
    }
}
