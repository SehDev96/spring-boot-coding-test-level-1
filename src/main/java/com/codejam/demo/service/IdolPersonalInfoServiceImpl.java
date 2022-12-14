package com.codejam.demo.service;


import com.codejam.demo.model.IdolPersonalInfo;
import com.codejam.demo.repository.IdolPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdolPersonalInfoServiceImpl implements IdolPersonalInfoService {

    @Autowired
    private IdolPersonalInfoRepository idolPersonalInfoRepository;

//    private final IdolPersonalInfoRepository idolPersonalInfoRepository;
//
//    @Autowired
//    public IdolPersonalInfoServiceImpl(IdolPersonalInfoRepository idolPersonalInfoRepository) {
//        this.idolPersonalInfoRepository = idolPersonalInfoRepository;
//    }

    @Override
    public IdolPersonalInfo saveIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo) {
        return idolPersonalInfoRepository.save(idolPersonalInfo);
    }

    @Override
    public IdolPersonalInfo updateIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo) {
        return null;
    }

    @Override
    public void deleteIdolPersonalInfo(Integer id) {
        idolPersonalInfoRepository.deleteById(id);
    }

    @Override
    public IdolPersonalInfo findById(Integer id) {
        return idolPersonalInfoRepository.findById(id).orElse(null);
    }
}
