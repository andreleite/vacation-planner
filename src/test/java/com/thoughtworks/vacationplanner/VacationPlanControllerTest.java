package com.thoughtworks.vacationplanner;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VacationPlanControllerTest {
    @Test
    public void returnsAllPossibleRangeDays() throws Exception {
        VacationPlanController vacationPlanController = new VacationPlanController();

        Map<String, String> params = new HashMap<>();
        params.put("city", "Porto Alegre");
        params.put("days", "15");
        params.put("weather", "Clear, Partly Cloudy, Cold");

        String response = vacationPlanController.vacationPlan(params);

        assertEquals("De 20 de Junho a 10 de Julho; De 09 de Maio a 26 de Maio; De 02 de Abril a 16 de Abril", response);
    }
}
