package com.mehdilagdimi.itsgovauthservice.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
public class User {

    public enum UserRole {
        SUPERADMIN,
        EMPLOYEE
    }

    public enum Ministry {
        FINANCE,
        HEALTHCARE
    }



    @Id @GeneratedValue
    private Long id;
    private String fullname;
    private String email;
    private Ministry ministry;
    private UserRole role;

    private Department department;
}
