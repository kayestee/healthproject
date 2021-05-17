package com.healthy.healthcheck.repository;


import com.healthy.healthcheck.backend.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

@Transactional
@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {

    Health findDistinctById(Long id);
    @Modifying
    @Query("update Health h set h.status = :status where h.id = :id")
    Integer updateById(@Param("id") Long id, @Param("status") String status);

}
