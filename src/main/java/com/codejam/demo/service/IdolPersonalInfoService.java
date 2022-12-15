package com.codejam.demo.service;

import com.codejam.demo.model.IdolPersonalInfo;

public interface IdolPersonalInfoService {

    IdolPersonalInfo saveIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo);

    IdolPersonalInfo updateIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo);

    void deleteIdolPersonalInfo(Integer id);

    IdolPersonalInfo findById(Integer id) throws Exception;

}
