package com.edu.appswbd.practica.cuatro.mysql.repository;

import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("companyRepository")
public interface CompanyRepository extends JpaRepository<Company, Serializable> {
    public abstract Company findById(int id);
}
