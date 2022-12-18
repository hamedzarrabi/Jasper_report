package com.hami.model;

import javax.persistence.*;

@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String job;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  Employee employee;
}
