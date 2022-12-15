DROP TABLE IF EXISTS PERSONAL_INFORMATION;
CREATE TABLE PERSONAL_INFORMATION (
    id int IDENTITY ,
    real_name varchar(50),
    idol_name varchar(60),
    address varchar(255),
    idol_status varchar(25)
                                  );

DROP TABLE IF EXISTS SCHEDULE;
CREATE TABLE SCHEDULE (
    id int IDENTITY ,
    idol_personal_info_id int,
    venue varchar(50),
    event_name varchar(60),
    date_time varchar(50),
    FOREIGN KEY (idol_personal_info_id) REFERENCES PERSONAL_INFORMATION(id)
                      );
DROP TABLE IF EXISTS REVENUE;
CREATE TABLE REVENUE (
    id int IDENTITY ,
    idol_personal_info_id int,
    monthly_rate varchar(50),
    date_time varchar(50),
    FOREIGN KEY (idol_personal_info_id) REFERENCES PERSONAL_INFORMATION(id)
                     );

INSERT INTO PERSONAL_INFORMATION (id, real_name, idol_name, address, idol_status) VALUES ('1', 'rahimi', 'remy', 'Malaysia', 'ACTIVE');
INSERT INTO SCHEDULE (id,idol_personal_info_id, venue, event_name, date_time) VALUES ('1','1', 'Stadium Bukit Jalil', 'World Tour-2025', '27/05/2025 08:47:59.751000000');
INSERT INTO REVENUE (id,idol_personal_info_id ,monthly_rate, date_time) VALUES ('1','1', '1000000', '27/05/2025 08:47:59.751000000');