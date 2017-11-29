package com.thoughtworks.vacationplanner;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class VacationPlanController {

    @RequestMapping("/hello")
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();

        City[] cities = restTemplate.getForObject("http://localhost:8882/cities/", City[].class);

        return cities[0].getDistrict();
    }
}
