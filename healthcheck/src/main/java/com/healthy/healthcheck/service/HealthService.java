package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.healthcheck.backend.Health;
import com.healthy.healthcheck.backend.Patient;
import com.healthy.healthcheck.repository.ContactInfoRepository;
import com.healthy.healthcheck.repository.HealthRepository;
import com.healthy.healthcheck.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class HealthService implements IHealthService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HealthRepository healthRepository;
    @Autowired
    private ContactInfoRepository contactRepository;


    @Override
    public ObjectNode healthCheckService(String format) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            if(format.equalsIgnoreCase("status")){
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date date = new Date();
                ObjectNode node = JsonNodeFactory.instance.objectNode();
                node.set("currentTime", JsonNodeFactory.instance.textNode(formatter.format(date)));
                node.set("application", JsonNodeFactory.instance.textNode("OK"));
                respNode.set("HealthData", node);
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
