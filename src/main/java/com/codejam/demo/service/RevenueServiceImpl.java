package com.codejam.demo.service;

import com.codejam.demo.exceptions.ResourceNotFoundException;
import com.codejam.demo.model.Revenue;
import com.codejam.demo.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueServiceImpl implements RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    @Override
    public Revenue saveRevenue(Revenue revenue) {

        return revenueRepository.save(revenue);
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        Revenue dbRevenue = revenueRepository.findById(revenue.getId()).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", revenue.getId());
        return revenueRepository.save(revenue);
    }

    @Override
    public void deleteRevenue(Integer id) {
        Revenue dbRevenue = revenueRepository.findById(id).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", id);
        revenueRepository.deleteById(id);
    }

    @Override
    public Revenue findById(Integer id) {
        Revenue dbRevenue = revenueRepository.findById(id).orElse(null);
        if (dbRevenue == null) throw new ResourceNotFoundException("Revenue", "id", id);
        return dbRevenue;
    }
}
