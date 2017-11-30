package com.thoughtworks.vacationplanner;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VacationPlanControllerTest {
    @Test
    public void retrievesQueryParameter() throws Exception {
        VacationPlanController vacationPlanController = new VacationPlanController();

        Map<String, String> params = new HashMap<>();
        params.put("city", "Porto Alegre");
        params.put("days", "10");
        params.put("weather", "clear");

        String response = vacationPlanController.vacationPlan(params);

        assertEquals("thunderstorms", response);
    }

}
