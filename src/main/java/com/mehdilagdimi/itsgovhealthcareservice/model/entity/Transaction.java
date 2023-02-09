package com.mehdilagdimi.itsgovhealthcareservice.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

    public enum Ministry {
        FINANCE,
        HEALTHCARE
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Ministry ministry;


}
