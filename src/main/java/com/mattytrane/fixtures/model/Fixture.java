package com.mattytrane.fixtures.model;

import java.util.Date;

public class Fixture {
    private Team homeTeam;
    private Team awayTeam;
    private Date datePlayed;
    private String result;
    private String venue;
    //TODO: implement a timeline field composed of Events and player actions.

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
       String formatted = String.format("%s v. %s%n @ %s on -Date- %n Result: %s",
               homeTeam,
               awayTeam,
               venue,
               result);
        return formatted;
    }
}
