package com.andyleo.multisolitaire.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "user_login")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Instant dateCreated;

    @Column
    private Instant dateUpdated;

}
