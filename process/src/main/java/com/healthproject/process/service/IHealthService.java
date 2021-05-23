package com.healthproject.process.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthproject.process.backend.Health;
import reactor.core.publisher.Flux;

public interface IHealthService {

    public Flux<ObjectNode> findByStatus(String format) throws Exception;

}
