package com.healthy.healthcheck;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.healthcheck.service.HealthService;
import com.healthy.healthcheck.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
@EnableAutoConfiguration
class HealthcheckController {

    @Autowired
    private IHealthService healthService;

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
    public ResponseEntity<Object> fetchIndividualInfo( @PathVariable Long patientId,  @PathVariable Long contactId ) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{

            HealthService healthService = new HealthService();
            respNode = healthService.patientService(patientId, contactId);

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


    @PostMapping(value = "/posthealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPost(@RequestParam String name, String status)  throws Exception{
//        Health health = healthRepository.save(new Health(name,status));
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("Update","Success");
        return new ResponseEntity<Object>(node, HttpStatus.OK);
    }

    @PostMapping(value = "/updatehealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPost(@RequestParam Long id, String name, String status)  throws Exception{
//        Health health = healthRepository.findDistinctById(id);
        ObjectNode node = JsonNodeFactory.instance.objectNode();
//        if (health.getId() == id) {
//            health.setStatus(status);
//            Integer resp = healthRepository.updateById(id = health.getId(), status =health.getStatus());
//            if (resp == 1) {
//                healthRepository.flush();
//                node.put("Update", "Success");
//            } else {
//                node.put("Update", "Failed");
//            }
//        }
        return new ResponseEntity<Object>(node, HttpStatus.OK);
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




