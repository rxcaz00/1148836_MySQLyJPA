package com.edu.appswbd.practica.cuatro.mysql.services.impl;

import com.edu.appswbd.practica.cuatro.mysql.components.ContactDetailConverter;
import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactDetailModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.ContactDetailRepository;
import com.edu.appswbd.practica.cuatro.mysql.services.ContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactDetailServiceImpl")
public class ContactDetailServiceImpl implements ContactDetailService {

    @Autowired
    @Qualifier("contactDetailRepository")
    private ContactDetailRepository contactDetailRepository;

    @Autowired
    @Qualifier("contactDetailConverter")
    private ContactDetailConverter contactDetailConverter;

    @Override
    public ContactDetailModel addContactDetail(ContactDetailModel contactDetailModel) throws Exception {
        ContactDetail temp = contactDetailConverter.convertContactDetailModel2ContactDetail(contactDetailModel);
        ContactDetail contactDetail = contactDetailRepository.save(temp);
        return contactDetailConverter.convertContactDetail2ContactDetailModel(contactDetail);
    }

    @Override
    public List<ContactDetailModel> listAllContactDetails() {
        List<ContactDetail> contactDetails = contactDetailRepository.findAll();
        List<ContactDetailModel> contactDetailsModel = new ArrayList();
        for(ContactDetail contactDetail : contactDetails)
            contactDetailsModel.add(contactDetailConverter.convertContactDetail2ContactDetailModel(contactDetail));
        return contactDetailsModel;
    }

    @Override
    public ContactDetail findContactDetailById(int id) {
        return contactDetailRepository.findById(id);
    }

    public ContactDetailModel findContactDetailByIdModel(int id) {
        return contactDetailConverter.convertContactDetail2ContactDetailModel(findContactDetailById(id));
    }

    @Override
    public void removeContactDetail(int id) {
        ContactDetail contactDetail = findContactDetailById(id);
        if(contactDetail != null)
            contactDetailRepository.delete(findContactDetailById(id));
    }
}
