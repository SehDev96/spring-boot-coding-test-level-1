package com.codejam.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REVENUE")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idol_personal_info_id")
    private Integer idol_personal_info_id;

    @Column(name = "monthly_rate")
    private String monthly_rate;

    @Column(name = "date_time")
    private String date_time;
}
