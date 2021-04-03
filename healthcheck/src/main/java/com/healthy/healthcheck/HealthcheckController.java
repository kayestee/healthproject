package com.healthy.healthcheck;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthy.backend.Health;
import com.healthy.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.EntityNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
class HealthcheckController {

    @Autowired
    private HealthRepository healthRepository;
    @GetMapping(value = "/healthcheck", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthcheck(@RequestParam String format) throws Exception{
        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
        try{
            if(format.equalsIgnoreCase("short")){
                respNode.put("status","OK");
                return new ResponseEntity<Object>(respNode, HttpStatus.OK);

            }else if (format.equalsIgnoreCase("full")){
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss Z");
                String datetimeStr = zonedDateTime.format(formatter);
                ObjectNode node = JsonNodeFactory.instance.objectNode();
                node.set("currentTime", JsonNodeFactory.instance.textNode(datetimeStr));
                node.set("application", JsonNodeFactory.instance.textNode("OK"));
                respNode.set("HealthData", node);
                return new ResponseEntity<Object>(node,HttpStatus.OK);

            } else {
                List<Health> health = (List<Health>) healthRepository.findAll();
                for (Health li : health){
                    ObjectNode node = JsonNodeFactory.instance.objectNode();
                    node.put("name", li.getName());
                    node.put("status", li.getStatus());
                    respNode.set(String.valueOf(li.getId()), node);
                };
                  System.out.println(health.size());
//                Health health = healthRepository.findDistinctById(new Long(1));
//                node.put("name", health.getName());
//                node.put("status", health.getStatus());

                return new ResponseEntity<Object>(respNode, HttpStatus.OK);
            }

        } catch(Exception ioe){
            System.out.println(ioe.getMessage());
            respNode.put("status","Bad Request");
            return new ResponseEntity<Object>(respNode, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/puthealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPut(@RequestParam String name, String status) {
        Health health = healthRepository.save(new Health(name,status));
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("Update","Success");
        return new ResponseEntity<Object>(node, HttpStatus.OK);
    }


    @PostMapping(value = "/posthealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPost(@RequestParam String name, String status)  throws Exception{
        Health health = healthRepository.save(new Health(name,status));
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("Update","Success");
        return new ResponseEntity<Object>(node, HttpStatus.OK);
    }

    @PostMapping(value = "/updatehealth" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> healthCheckPost(@RequestParam Long id, String name, String status)  throws Exception{
        Health health = healthRepository.findDistinctById(id);
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        if (health.getId() == id) {
            health.setName(name);
            health.setStatus(status);
            Integer resp = healthRepository.updateById(id = health.getId(), name
                     = health.getName(), status =health.getStatus());
            if (resp == 1) {
                healthRepository.flush();
                node.put("Update", "Success");
            } else {
                node.put("Update", "Failed");
            }
        }
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




