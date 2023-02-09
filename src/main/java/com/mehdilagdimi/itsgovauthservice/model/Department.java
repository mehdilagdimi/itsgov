package com.mehdilagdimi.itsgovauthservice.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class Department {

    @Id
    @GeneratedValue
    Long id;

    String name;

    List<User> users;
}
