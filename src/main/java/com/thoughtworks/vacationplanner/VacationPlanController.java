package com.thoughtworks.vacationplanner;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@RestController
public class VacationPlanController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/vacation-plan")
    public String vacationPlan(@RequestParam Map<String, String> queryParameters) {
        String cityId = getCityIdFromName(queryParameters.get("city"));

        return requestCityWeathers(cityId)[0].getWeather();
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

    private Weather[] requestCityWeathers(String cityId) {
        return restTemplate.getForObject(String.format("http://localhost:8882/cities/%s/year/2017", cityId), Weather[].class);
    }
}
