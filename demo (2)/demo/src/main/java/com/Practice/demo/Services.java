package com.Practice.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    private List<CoronaModel> stats = new ArrayList<>();
    String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    String url2 = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
    public List<CoronaModel> getStats() {
        return stats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetch() throws IOException, InterruptedException {
        List<CoronaModel> newstats = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        StringReader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            CoronaModel coronaModel = new CoronaModel();
            coronaModel.setState(record.get("Province/State"));
            coronaModel.setCountry(record.get("Country/Region"));
            coronaModel.setLatestToatalCases(Integer.parseInt(record.get(record.size() - 1)));
            newstats.add(coronaModel);
        }
        this.stats = newstats;
    }

    private List<CoronaModel2> stats2 = new ArrayList<>();
    public List<CoronaModel2> getStats2() {
        return stats2;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchDeath() throws IOException, InterruptedException {
        List<CoronaModel2> newstats = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url2))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        StringReader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            CoronaModel2 coronaModel = new CoronaModel2();
            coronaModel.setState(record.get("Province/State"));
            coronaModel.setCountry(record.get("Country/Region"));
            coronaModel.setLatestToatalDeath(Integer.parseInt(record.get(record.size() - 1)));
            newstats.add(coronaModel);
        }
        this.stats2 = newstats;
    }
}
