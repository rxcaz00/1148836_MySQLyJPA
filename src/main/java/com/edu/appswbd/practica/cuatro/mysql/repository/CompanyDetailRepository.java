package com.edu.appswbd.practica.cuatro.mysql.repository;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("companyDetailRepository")
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, Serializable> {
    public abstract CompanyDetail findById(int id);
}
