package com.edu.appswbd.practica.cuatro.mysql.repository;

import com.edu.appswbd.practica.cuatro.mysql.entity.CompanyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CompanyStatusRepository extends JpaRepository<CompanyStatus, Serializable> {
    public abstract CompanyStatus findById(int id);
}
