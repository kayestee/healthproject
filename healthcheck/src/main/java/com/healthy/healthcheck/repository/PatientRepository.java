package com.healthy.healthcheck.repository;


import com.healthy.healthcheck.backend.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;


@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);
    Patient findDistinctById(Long id);

    @Modifying
    @Query("update Patient h set h.name = :name, h.status = :status, h.sex = :sex, h.birthdate = :birthdate, h.contactid = :contactid  where h.id = :id")
    Integer updateById(@Param("id") Long id, @Param("status") String status,
                       @Param("sex") String sex, @Param("birthdate") Date birthdate, @Param("contactid") Long contactid);

}
