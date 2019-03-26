package com.edu.appswbd.practica.cuatro.mysql.components;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.entity.Contact;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactModel;
import com.edu.appswbd.practica.cuatro.mysql.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component("contactConverter")
public class ContactConverter {

    @Autowired
    @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    public Contact convertContactModel2Contact(ContactModel contactModel) {
        Contact contact = new Contact();
        List<Company> companies = companyRepository.findAll();
        for(Company company : companies)
            if(company.getName().equals(contactModel.getCompany())) {
                contact.setCompany(company);
                break;
            }
        contact.setEmail(contactModel.getEmail());
        contact.setFirstname(contactModel.getFirstname());
        contact.setId(contactModel.getId());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        try {
            String[] dates = contactModel.getVersion().split("T");
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dates[0] + " " + dates[1]);
            contact.setVersion(date);
        } catch (Exception e) {

        }
        contact.setContactDetailList(contactModel.getContactDetailList());
        return contact;
    }

    public ContactModel convertContact2ContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setCompany(contact.getCompany().getName());
        contactModel.setEmail(contact.getEmail());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setId(contact.getId());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setVersion(contact.getVersion().toString());
        contactModel.setContactDetailList(contact.getContactDetailList());
        return contactModel;
    }
}