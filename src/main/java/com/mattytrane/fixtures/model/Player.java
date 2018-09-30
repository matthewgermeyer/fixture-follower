package com.mattytrane.fixtures.model;

public class Player {
    String name;
    int shirtNumber;
    //TODO: Make position into an ENUM
    String position;
    StatCard card;

    public Player(String name) {
        this.name = name;
        this.shirtNumber = 0;
        this.position = "not Set";
        this.card = new StatCard();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StatCard getCard() {
        return card;
    }

    public void setCard(StatCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return String.format("%s%n", name);

    }
}
