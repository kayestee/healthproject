package com.healthy.healthcheck.repository;


import com.healthy.healthcheck.backend.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
    List<ContactInfo> findByFirstnameAndLastname(String firstname, String lastname);
    ContactInfo findDistinctByContactid(Long contactid);

    @Modifying
    @Query("update ContactInfo h set h.firstname = :firstname, h.lastname = :lastname, h.address = :address, " +
            "h.state = :state, h.country = :country, h.phone = :phone  where h.contactid = :contactid")
    Integer updateById(@Param("contactid") Long contactid, @Param("firstname") String firstname,
             @Param("lastname") String lastname, @Param("address") String address,
             @Param("state") String state, @Param("country") String country , @Param("phone") String phone);



}
