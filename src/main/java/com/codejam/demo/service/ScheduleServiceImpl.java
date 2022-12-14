package com.codejam.demo.service;

import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

//    private final ScheduleRepository scheduleRepository;
//
//    @Autowired
//    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
//        this.scheduleRepository = scheduleRepository;
//    }


    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return null;
    }

    @Override
    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule findById(Integer id) {
        return scheduleRepository.findById(id).orElse(null);
    }
}
