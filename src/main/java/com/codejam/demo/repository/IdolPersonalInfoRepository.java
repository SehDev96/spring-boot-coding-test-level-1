package com.codejam.demo.repository;

import com.codejam.demo.model.IdolPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdolPersonalInfoRepository extends JpaRepository<IdolPersonalInfo,Integer> {

}
