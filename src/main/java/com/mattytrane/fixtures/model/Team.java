package com.mattytrane.fixtures.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Team {
    private String name;
    private String manager;
    private String homeGround;
    private String slug;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(manager, team.manager) &&
                Objects.equals(homeGround, team.homeGround) &&
                Objects.equals(roster, team.roster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manager, homeGround, roster);
    }

    private List<Player> roster;

    private static final String SPURS_NAME = "Tottenham Hotspur FC";
    private static final String SPURS_MANAGER = "Mauricio Pochetino";
    private static final String SPURS_GROUND = "White Hart Lane";
    private static final List<String> SPURS_PLAYERS_NAMES = Arrays.asList(
            "Hugo Lloris",
            "Toby Alderweireld",
            "Jan Vertonghen",
            "Davinson Sanchez",
            "Kieren Trippier",
            "Ben Davies",
            "Moussa Dembele",
            "Eric Dier",
            "Christian Eriksen",
            "Erik Lamela",
            "Son Heung Min",
            "Harry Kane",
            "Lucas Moura",
            "Danny Rose"
    );

    public Team(String name, String manager, String homeGround, List<Player> roster) {
        this.name = name;
        this.manager = manager;
        this.homeGround = homeGround;
        this.roster = roster;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public List<Player> getroster() {
        return roster;
    }

    @Override
    public String toString() {
        String result = String.format(
                        "Team: %s%n " +
                        "Manager: %s%n Venue: %s%n%n " +
                        "Roster: %n %s%n",
                name,
                manager,
                homeGround,
                roster);
        return result.replace("[", "").replace("]", "").replace(",","");

    }

    public static Team generateSpursTeam() {
        Team spurs = new Team(SPURS_NAME, SPURS_MANAGER, SPURS_GROUND, generateSpursRoster());
        System.out.printf("Generating Team : Spurs%n%s", spurs.toString());
        return spurs;
    }

    private static List<Player> generateSpursRoster() {
        ArrayList<Player> spursRoster = new ArrayList<>();
        if (SPURS_PLAYERS_NAMES != null) {
            for (String name : SPURS_PLAYERS_NAMES) {
                Player p = new Player(name);
                spursRoster.add(p);
            }
        }
        return spursRoster;
    }

} //class
