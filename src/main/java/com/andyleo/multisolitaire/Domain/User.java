package com.andyleo.multisolitaire.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

}
