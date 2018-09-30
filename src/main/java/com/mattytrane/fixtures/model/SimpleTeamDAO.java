package com.mattytrane.fixtures.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleTeamDAO implements TeamDAO {
    private List<Team> teams;

    public SimpleTeamDAO() {
        teams = new ArrayList<>();
        teams.add(Team.generateSpursTeam());
    }

    @Override
    public boolean add(Team team) {
        return teams.add(team);

    }

    @Override
    public List<Team> findAll() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<Player> getPlayers(Team team) {
        return team.getroster();
    }

    @Override
    public List<String> getPlayerNamesForTeam(Team team) {
        List<Player> players = team.getroster();
        List<String> playerNames = new ArrayList<>();

        if (players != null) {
            for (Player p : players) {
                playerNames.add(p.getName());
            }
        }
        return playerNames;
    }

    @Override
    public String getManager(Team team) {
        return team.getManager();
    }

    @Override
    public String getVenue(Team team) {
        return team.getHomeGround();
    }

    @Override
    public String getTeamName(Team team) {
        return team.getName();
    }

    @Override
    public List<String> getTeamNames() {
        ArrayList<String> teamNames = new ArrayList<>();
        if (teams != null) {
            for (Team t : teams) {
                teamNames.add(t.getName());
            }
        }
        System.out.println(teamNames);
        return teamNames;
    }

    @Override
    public Team findBySlug(String slug) {
        return teams.stream()
                .filter(team -> team.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
} //class
