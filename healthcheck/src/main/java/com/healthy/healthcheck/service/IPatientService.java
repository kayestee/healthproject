package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Map;

public interface IPatientService {

    ObjectNode patientService(Long patientId, Long contactId) throws Exception;

    ObjectNode updatePatientDetails(Map<String,String> requestParams) throws Exception;


}
