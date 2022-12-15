package com.codejam.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PERSONAL_INFORMATION")
public class IdolPersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "real_name")
    private String real_name;

    @Column(name = "idol_name")
    private String idol_name;

    @Column(name = "address")
    private String address;

    @Column(name = "idol_status")
    private String idol_status;
}
