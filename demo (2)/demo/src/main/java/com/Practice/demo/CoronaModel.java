package com.Practice.demo;

public class CoronaModel {

    private String State;
    private String Country;
    private int latestToatalCases;

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

    public int getLatestToatalCases() {
        return latestToatalCases;
    }

    public void setLatestToatalCases(int latestToatalCases) {
        this.latestToatalCases = latestToatalCases;
    }

    @Override
    public String toString() {
        return "CoronaModel{" +
                "State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", latestToatalCases=" + latestToatalCases +
                '}';
    }
}
