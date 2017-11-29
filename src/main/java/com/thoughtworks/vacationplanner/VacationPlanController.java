package com.thoughtworks.vacationplanner;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class VacationPlanController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/hello")
    public String hello() {
        City[] cities = requestCities();

        return cities[0].getDistrict();
    }

    @RequestMapping("/vacation-plan")
    public String vacationPlan(@RequestParam Map<String, String> queryParameters) {
        return getCityIdFromName(queryParameters.get("city"));
    }

    private String getCityIdFromName(String city) {
        
        return Arrays.stream(requestCities())
            .filter(c -> c.getDistrict().equals(city))
            .findFirst()
            .map(City::getWoeid)
            .orElse(null);
    }

    private City[] requestCities() {
        return restTemplate.getForObject("http://localhost:8882/cities/", City[].class);
    }
}
