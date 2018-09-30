package com.mattytrane.fixtures.model;

import java.util.List;

public interface TeamDAO {
    boolean add(Team team);
    List<Team> findAll();
    List<Player> getPlayers(Team team);
    List<String> getPlayerNamesForTeam(Team team);
    String getManager(Team team);
    String getVenue(Team team);
    String getTeamName(Team team);
    List<String> getTeamNames();
    Team findBySlug(String slug);
}
