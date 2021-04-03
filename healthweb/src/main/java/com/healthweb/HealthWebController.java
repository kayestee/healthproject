package com.healthweb;

import com.healthweb.beans.Health;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/viewrecords")
public class HealthWebController {

    @GetMapping("/allrecords")
    public String viewHealthRecords(@RequestParam(name="name", required = false, defaultValue = "Kalyan")
                                                String name, Model model){
        RestTemplate restCall = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        Health health = new Health();
        Object result =  restCall.getForObject("http://healthcheck-cont:8080/healthcheck?format={name}",String.class, health);
        model.addAttribute("name", name);
        return "viewrecords";

    }
}
