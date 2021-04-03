package com.healthy.repository;


import com.healthy.backend.Health;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {


    List<Health> findByName(String name);


    Health findDistinctById(Long id);

    @Modifying
    @Transactional()
    @Query("update Health h set h.name = :name, h.status = :status where h.id = :id")
    Integer updateById(@Param("id") Long id, @Param("name") String name, @Param("status") String status);


}
