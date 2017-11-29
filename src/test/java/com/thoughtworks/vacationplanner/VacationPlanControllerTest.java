package com.thoughtworks.vacationplanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VacationPlanControllerTest {

    @Test
    public void hello() throws Exception {
        VacationPlanController vacationPlanControllerTest = new VacationPlanController();

        String hello = vacationPlanControllerTest.hello();

        assertEquals("Porto Alegre", hello);
    }
}
