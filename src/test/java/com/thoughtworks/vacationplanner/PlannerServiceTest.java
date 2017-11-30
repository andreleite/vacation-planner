package com.thoughtworks.vacationplanner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlannerServiceTest {

    private PlannerService plannerService;

    @Before
    public void setUp() {
        plannerService = new PlannerService();
    }

    @Test
    public void getIntervals() {
        Weather[] weathers = new Weather[] {
            new Weather("clear", "2017-01-01"),
            new Weather("clear", "2017-01-02")
        };

        String interval = plannerService.getIntervals("2", "clear", weathers);

        assertThat(interval).isEqualTo("from 2017-01-01 to 2017-01-02");
    }
}