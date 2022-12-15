package com.codejam.demo.service;

import com.codejam.demo.model.Revenue;

public interface RevenueService {

    Revenue saveRevenue(Revenue revenue);

    Revenue updateRevenue(Revenue revenue);

    void deleteRevenue(Integer id);

    Revenue findById(Integer id);

}