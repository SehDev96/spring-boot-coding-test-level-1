package com.codejam.demo.service;

import com.codejam.demo.exceptions.ResourceNotFoundException;
import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        Schedule dbSchedule = scheduleRepository.findById(schedule.getId()).orElse(null);
        if (dbSchedule == null) throw new ResourceNotFoundException("Schedule", "id", schedule.getId());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Integer id) {
        Schedule dbSchedule = scheduleRepository.findById(id).orElse(null);
        if (dbSchedule == null) throw new ResourceNotFoundException("Schedule", "id", id);
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule findById(Integer id) {
        Schedule dbSchedule = scheduleRepository.findById(id).orElse(null);
        if (dbSchedule == null) throw new ResourceNotFoundException("Schedule", "id", id);
        return dbSchedule;
    }
}
