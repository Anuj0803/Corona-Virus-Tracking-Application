package com.Practice.demo;

public class CoronaModel2 {

    private String State;
    private String Country;
    private int latestToatalDeath;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getLatestToatalDeath() {
        return latestToatalDeath;
    }

    public void setLatestToatalDeath(int latestToatalDeath) {
        this.latestToatalDeath = latestToatalDeath;
    }

    @Override
    public String toString() {
        return "CoronaModel2{" +
                "State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", latestToatalDeath=" + latestToatalDeath +
                '}';
    }
}
