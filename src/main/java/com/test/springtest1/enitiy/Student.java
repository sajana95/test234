package com.test.springtest1.enitiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Date birthDay;
    private String address;
    private String phoneNumber;
}
