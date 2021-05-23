package com.healthproject.process.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthproject.process.backend.Health;
import com.healthproject.process.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class HealthService implements IHealthService {


    @Autowired
    private HealthRepository healthRepository;


    @Override
    public Flux<ObjectNode> findByStatus(String status) throws Exception{
        Flux<Health> healthFlux =  healthRepository.findByStatus(status);
        return healthFlux.map((health) -> {
            ObjectNode respNode = JsonNodeFactory.instance.objectNode();
            respNode.put("id",health.getId());
            respNode.put("status",health.getStatus());
            return respNode;
        });

    }
}
