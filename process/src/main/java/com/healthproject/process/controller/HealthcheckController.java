package com.healthproject.process.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.healthproject.process.backend.Health;
import com.healthproject.process.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@EnableAutoConfiguration
class HealthcheckController {

    @Autowired
    private IHealthService healthService;

    @GetMapping(value = "/healthdata", produces = MediaType.TEXT_EVENT_STREAM_VALUE )
    Flux<ObjectNode> healthcheck(@RequestParam String status) throws Exception{
//        ObjectNode respNode = JsonNodeFactory.instance.objectNode();
//        try{
          return   healthService.findByStatus(status);
//        } catch(Exception ioe){
//            System.out.println(ioe);
//
//        }
//        return respNode;
    }


}




