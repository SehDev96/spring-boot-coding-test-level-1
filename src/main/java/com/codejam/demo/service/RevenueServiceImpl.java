package com.codejam.demo.service;

import com.codejam.demo.model.Revenue;
import com.codejam.demo.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueServiceImpl implements RevenueService{

    @Autowired
    private RevenueRepository revenueRepository;

//    private final RevenueRepository revenueRepository;
//
//    @Autowired
//    public RevenueServiceImpl(RevenueRepository revenueRepository) {
//        this.revenueRepository = revenueRepository;
//    }


    @Override
    public Revenue saveRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        return null;
    }

    @Override
    public void deleteRevenue(Integer id) {
        revenueRepository.deleteById(id);
    }

    @Override
    public Revenue findById(Integer id) {
        return revenueRepository.findById(id).orElse(null);
    }
}
