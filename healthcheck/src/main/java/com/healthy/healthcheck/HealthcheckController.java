package com.healthy.healthcheck;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.healthcheck.service.HealthService;
import com.healthy.healthcheck.service.IHealthService;
import com.healthy.healthcheck.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Map;


@RestController
@EnableAutoConfiguration
class HealthcheckController {

    @Autowired
    private IHealthService healthService;
    @Autowired
    private IPatientService patientService;

    @GetMapping(value = "/healthcheck", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthcheck(@RequestParam String format) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            respNode = healthService.healthCheckService(format);
        } catch(Exception ioe){
            System.out.println(ioe);
            respNode.put("status","Bad Request");
            return new ResponseEntity<Object>(respNode, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(respNode, HttpStatus.OK);
    }

    @GetMapping(value = "/patientinfo/{patientId}/{contactId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> fetchPatientContactInfo( @PathVariable Long patientId,  @PathVariable Long contactId ) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            respNode = patientService.patientService(patientId, contactId);

        } catch(Exception ioe){
            System.out.println(ioe.getMessage());
            respNode.put("status","Bad Request");
            return new ResponseEntity<Object>(respNode, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(respNode, HttpStatus.OK);
    }


    @PutMapping(value = "/puthealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPut(@RequestParam String name, String status) {
//        Health health = healthRepository.save(new Health(name,status));
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("Update","Success");
        return new ResponseEntity<Object>(node, HttpStatus.OK);
    }


    @PostMapping(value = "/updatehealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPost(@RequestParam Map<String, String> params)  throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        respNode = patientService.updatePatientDetails(params);
        return new ResponseEntity<Object>(respNode, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteinfo" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public void healthCheckDelete() {
        return;
    }

    @PostMapping(value = "/removeinfo" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public void healthCheckPostDelete() {
        return;
    }

}




