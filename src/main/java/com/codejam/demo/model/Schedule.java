package com.codejam.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SCHEDULE")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idol_personal_info_id")
    private Integer idol_personal_info_id;

    @Column(name = "venue")
    private String venue;

    @Column(name = "event_name")
    private String event_name;

    @Column(name = "date_time")
    private String date_time;
}
