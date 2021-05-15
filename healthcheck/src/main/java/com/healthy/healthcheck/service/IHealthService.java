package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IHealthService {

    ObjectNode healthCheckService(String format) throws Exception;

    ObjectNode patientService(String format) throws Exception;



}
