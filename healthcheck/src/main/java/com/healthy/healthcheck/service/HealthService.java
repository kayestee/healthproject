package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.healthcheck.backend.Health;
import com.healthy.healthcheck.backend.Patient;
import com.healthy.healthcheck.repository.HealthRepository;
import com.healthy.healthcheck.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class HealthService implements IHealthService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HealthRepository healthRepository;


    @Override
    public ObjectNode healthCheckService(String format) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            if(format.equalsIgnoreCase("status")){
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss Z");
                String datetimeStr = zonedDateTime.format(formatter);
                ObjectNode node = JsonNodeFactory.instance.objectNode();
                node.set("currentTime", JsonNodeFactory.instance.textNode(datetimeStr));
                node.set("application", JsonNodeFactory.instance.textNode("OK"));
                respNode.set("HealthData", node);
            }else if (format.equalsIgnoreCase("full")){
                List<Health> health = (List<Health>) healthRepository.findAll();
                ArrayNode jsonArray = JsonNodeFactory.instance.arrayNode();
                for (Health li : health){
                    ObjectNode node = JsonNodeFactory.instance.objectNode();
                    node.put("id", li.getId());
                    node.put("status", li.getStatus());
                    Patient patient =   patientRepository.findDistinctById(li.getId());
                    node.put("name", patient.getName());
                    node.put("status", patient.getStatus());
                    node.put("sex", patient.getSex());
                    node.put("birthdate", patient.getBirthdate().toString());
                    node.put("contactid", patient.getContactid());
                    jsonArray.add(node);
                };
                respNode.put("record_name", "Health Records");
                respNode.set("items", jsonArray);
            }

        } catch(Exception ioe){
            System.out.println(ioe);
            respNode.put("status","Bad Request");
            return respNode;
        }
        return respNode;
    }

    @Override
    public ObjectNode patientService(String format) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            if(format.equalsIgnoreCase("status")){
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss Z");
                String datetimeStr = zonedDateTime.format(formatter);
                ObjectNode node = JsonNodeFactory.instance.objectNode();
                node.set("currentTime", JsonNodeFactory.instance.textNode(datetimeStr));
                node.set("application", JsonNodeFactory.instance.textNode("OK"));
                respNode.set("HealthData", node);
            }else if (format.equalsIgnoreCase("full")){
                List<Health> health = (List<Health>) healthRepository.findAll();
                ArrayNode jsonArray = JsonNodeFactory.instance.arrayNode();
                for (Health li : health){
                    ObjectNode node = JsonNodeFactory.instance.objectNode();
                    node.put("id", li.getId());
                    node.put("status", li.getStatus());
                    Patient patient =   patientRepository.findDistinctById(li.getId());
                    node.put("name", patient.getName());
                    node.put("status", patient.getStatus());
                    node.put("sex", patient.getSex());
                    node.put("birthdate", patient.getBirthdate().toString());
                    node.put("contactid", patient.getContactid());
                    jsonArray.add(node);
                };
                respNode.put("record_name", "Health Records");
                respNode.set("items", jsonArray);
            }

        } catch(Exception ioe){
            System.out.println(ioe);
            respNode.put("status","Bad Request");
            return respNode;
        }
        return respNode;
    }



}
