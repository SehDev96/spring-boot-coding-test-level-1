package com.codejam.demo.repository;

import com.codejam.demo.model.IdolPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdolPersonalInfoRepository extends JpaRepository<IdolPersonalInfo,Integer> {

    @Query("select u from IdolPersonalInfo u where u.idol_name = :name")
    Optional<IdolPersonalInfo> findIdolPersonalInfoByIdolName(@Param("name") String name);

    @Query(value = "select * from PERSONAL_INFORMATION order by rand() limit 1",nativeQuery = true)
    Optional<IdolPersonalInfo> getRandomIdolPersonalInfo();
}
