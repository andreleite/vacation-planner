package com.thoughtworks.vacationplanner;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VacationPlanController {

    @RequestMapping("/hello")
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();

        City[] cities = restTemplate.getForObject("http://localhost:8882/cities/", City[].class);

        return cities[0].getDistrict();
    }

    @RequestMapping("/vacation-plan")
    public Map<String, String> vacationPlan(@RequestParam Map<String, String> queryParameters) {
        return queryParameters;
    }
}
