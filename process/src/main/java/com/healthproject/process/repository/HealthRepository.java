package com.healthproject.process.repository;


import com.healthproject.process.backend.Health;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface HealthRepository extends ReactiveCrudRepository<Health, Long> {

    @Override
    Flux<Health> findAll();

    @Query("select * from health h where h.status = :status")
    Flux<Health>  findByStatus(String status);

    @Query("update health h set h.status = :status where h.id = :id")
    Integer updateById(@Param("id") Long id, @Param("status") String status);

}
