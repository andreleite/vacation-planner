package com.thoughtworks.vacationplanner;

public class PlannerService {

    public String getIntervals(String days, String weather, Weather[] weathers) {
        return String.format("from %s to %s", weathers[0].getDate(), weathers[1].getDate());
    }
}
