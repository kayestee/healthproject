package com.healthy.healthcheck.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.healthcheck.backend.ContactInfo;
import com.healthy.healthcheck.backend.Patient;
import com.healthy.healthcheck.repository.ContactInfoRepository;
import com.healthy.healthcheck.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;


@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ContactInfoRepository contactRepository;

    @Override
    public ObjectNode patientService(Long patientId, Long contactId) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            Patient p = patientRepository.findDistinctById(patientId);
            System.out.println(p);
            ArrayNode jsonArray = JsonNodeFactory.instance.arrayNode();
            ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("patientid", p.getId());
            node.put("patientname", p.getName());
            node.put("status", p.getStatus());
            node.put("sex", p.getSex());
            node.put("birthdate", p.getBirthdate().toString());
            ContactInfo cInfo =   contactRepository.findDistinctByContactid(p.getContactid());
            System.out.println(cInfo);
            ObjectNode cnode = JsonNodeFactory.instance.objectNode();
            cnode.put("contactid", cInfo.getcontactid());
            cnode.put("FirstName", cInfo.getFirstname());
            cnode.put("LastName", cInfo.getLastname());
            cnode.put("Address", cInfo.getAddress());
            cnode.put("State", cInfo.getState());
            cnode.put("Country", cInfo.getCountry());
            cnode.put("Phone", cInfo.getPhone());
            node.put("contact", cnode);
            jsonArray.add(node);
            respNode.set("Patient_Info", jsonArray );


        } catch(Exception ioe){
            System.out.println(ioe);
            respNode.put("status","Bad Request");
            return respNode;
        }
        return respNode;
    }


    @Override
    public ObjectNode updatePatientDetails(Map<String, String> requestParams) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        System.out.println(requestParams);
        try{
            ArrayNode jsonArray = JsonNodeFactory.instance.arrayNode();
            Object node = JsonNodeFactory.instance.objectNode();
            Patient p = patientRepository.findDistinctById(Long.valueOf(requestParams.get("patientid")));
            p.setName(requestParams.get("patientname"));
            p.setStatus(requestParams.get("status"));
            p.setSex(requestParams.get("sex"));
            Date date = Date.valueOf(requestParams.get("birthdate"));
            p.setBirthdate(date);
            ContactInfo cInfo =   contactRepository.findDistinctByContactid(p.getContactid());
            ObjectNode cnode = JsonNodeFactory.instance.objectNode();
            cnode.put("contactid", cInfo.getcontactid());
            cnode.put("FirstName", cInfo.getFirstname());
            cnode.put("LastName", cInfo.getLastname());
            cnode.put("Address", cInfo.getAddress());
            cnode.put("State", cInfo.getState());
            cnode.put("Country", cInfo.getCountry());
            cnode.put("Phone", cInfo.getPhone());
            jsonArray.add(cnode);
            respNode.set("Patient_Info", jsonArray );
        } catch(Exception ioe){
            System.out.println(ioe);
            respNode.put("status","Bad Request");
            return respNode;
        }
        return respNode;
    }



}
