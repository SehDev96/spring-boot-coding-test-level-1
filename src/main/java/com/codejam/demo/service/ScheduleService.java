package com.codejam.demo.service;

import com.codejam.demo.model.Schedule;

public interface ScheduleService {

    Schedule saveSchedule(Schedule schedule);

    Schedule updateSchedule(Schedule schedule);

    void deleteSchedule(Integer id);

    Schedule findById(Integer id);
}
