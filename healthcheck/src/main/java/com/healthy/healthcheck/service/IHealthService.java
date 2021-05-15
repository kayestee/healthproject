package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IHealthService {

    ObjectNode healthCheckService(String format) throws Exception;

    ObjectNode patientService(Long patientId, Long contactId) throws Exception;



}
