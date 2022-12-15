package com.codejam.demo.model;

import lombok.Data;

@Data
public class TodoResponse {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
