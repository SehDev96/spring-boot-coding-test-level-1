package com.codejam.demo.service;


import com.codejam.demo.exceptions.ResourceExistException;
import com.codejam.demo.exceptions.ResourceNotFoundException;
import com.codejam.demo.model.IdolPersonalInfo;
import com.codejam.demo.repository.IdolPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdolPersonalInfoServiceImpl implements IdolPersonalInfoService {

    @Autowired
    private IdolPersonalInfoRepository idolPersonalInfoRepository;

    @Override
    public IdolPersonalInfo saveIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo) {
        IdolPersonalInfo dbPersonalInfo = idolPersonalInfoRepository.findIdolPersonalInfoByIdolName(idolPersonalInfo.getIdol_name()).orElse(null);
        if (dbPersonalInfo != null) throw new ResourceExistException("Idol Personal Information", "idol_name",idolPersonalInfo.getIdol_name());
        return idolPersonalInfoRepository.save(idolPersonalInfo);
    }

    @Override
    public IdolPersonalInfo updateIdolPersonalInfo(IdolPersonalInfo idolPersonalInfo) {
        IdolPersonalInfo dbPersonalInfo = idolPersonalInfoRepository.findById(idolPersonalInfo.getId()).orElse(null);
        if(dbPersonalInfo == null) throw new ResourceNotFoundException("Idol Personal Information","id",idolPersonalInfo.getId());
        return idolPersonalInfoRepository.save(idolPersonalInfo);
    }

    @Override
    public void deleteIdolPersonalInfo(Integer id) {
        IdolPersonalInfo idolPersonalInfo = idolPersonalInfoRepository.findById(id)
                .orElse(null);
        if(idolPersonalInfo == null) throw new ResourceNotFoundException("Idol Personal Information","id",id);
        idolPersonalInfoRepository.deleteById(id);
    }

    @Override
    public IdolPersonalInfo findById(Integer id) {
        IdolPersonalInfo idolPersonalInfo = idolPersonalInfoRepository.findById(id).orElse(null);
        if(idolPersonalInfo == null) throw new ResourceNotFoundException("Idol Personal Information","id",id);
        return idolPersonalInfo;
    }

    @Override
    public IdolPersonalInfo getRandomIdolPersonalInfo() {

        return idolPersonalInfoRepository.getRandomIdolPersonalInfo().orElse(null);
    }
}
