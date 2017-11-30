package com.thoughtworks.vacationplanner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlannerService {

    public String getIntervals(String days, String weather, Weather[] weathers) {
        List<Weather> filteredWeathers = Arrays.stream(weathers)
                .filter(w -> w.getWeather().equals(weather))
                .collect(Collectors.toList());
        return String.format("from %s to %s", filteredWeathers.get(0).getDate(), filteredWeathers.get(filteredWeathers.size() - 1).getDate());
    }
}
