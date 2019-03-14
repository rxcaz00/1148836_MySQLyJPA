package com.edu.appswbd.practica.cuatro.mysql.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "contactdetail")
public class ContactDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "gender")
    private int gender;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "contactId")
    private Contact contact;

    public ContactDetail(int id, int gender, Date dateOfBirth, Contact contact) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }
}
