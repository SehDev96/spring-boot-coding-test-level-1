package com.codejam.demo;

import com.codejam.demo.model.IdolPersonalInfo;
import com.codejam.demo.service.IdolPersonalInfoService;
import com.codejam.demo.service.IdolPersonalInfoServiceImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


@DataJpaTest
@Import(IdolPersonalInfoServiceImpl.class)
public class IdolPersonalInfoServiceTest {

    @Autowired
    private IdolPersonalInfoService idolPersonalInfoService;

    @BeforeEach
    public void addUsers() {
        IdolPersonalInfo idolPersonalInfo = new IdolPersonalInfo();
        idolPersonalInfo.setIdol_status("INACTIVE");
        idolPersonalInfo.setIdol_name("MJ");
        idolPersonalInfo.setAddress("USA");
        idolPersonalInfo.setReal_name("MICHAEL JACKSON");
        idolPersonalInfoService.saveIdolPersonalInfo(idolPersonalInfo);
    }

    @Test
    public void getRandomPersonalInfo() throws Exception {
        IdolPersonalInfo idolPersonalInfo = idolPersonalInfoService.getRandomIdolPersonalInfo();
        BDDAssertions.assertThat(idolPersonalInfo).isNotNull();
        BDDAssertions.assertThat(idolPersonalInfo.getIdol_status()).isEqualTo("ACTIVE");
    }
}
