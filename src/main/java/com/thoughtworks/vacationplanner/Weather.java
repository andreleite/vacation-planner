package com.thoughtworks.vacationplanner;

public class Weather {
   private String weather;

   private String date;

   public Weather() {
      // Jackson needs a default constructor for our use case
      // TODO: Find out how to not depend on a default ctor
   }

   public Weather(String weather, String date) {
      this.weather = weather;
      this.date = date;
   }

   public String getWeather() {
      return weather;
   }

   public String getDate() {
      return date;
   }
}
