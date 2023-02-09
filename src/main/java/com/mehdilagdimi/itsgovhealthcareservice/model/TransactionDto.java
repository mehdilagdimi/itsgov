package com.mehdilagdimi.itsgovhealthcareservice.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.mehdilagdimi.itsgovhealthcareservice.model.entity.Transaction;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {
    private Long id;
    private String name;
    private String description;
    private Transaction.Ministry ministry;
}
