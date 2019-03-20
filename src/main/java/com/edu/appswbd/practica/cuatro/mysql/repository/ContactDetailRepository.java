package com.edu.appswbd.practica.cuatro.mysql.repository;

import com.edu.appswbd.practica.cuatro.mysql.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Serializable> {
    public abstract ContactDetail findById(int id);
}
