package com.mattytrane.fixtures.model;

import java.util.ArrayList;
import java.util.List;

public class StatCard {
    boolean isStarter;
    boolean isSubbed;
    List<Action> actionList;

    public StatCard() {
        this.isStarter = false;
        this.isSubbed = false;
        this.actionList = new ArrayList<>();
    }

    public boolean isStarter() {
        return isStarter;
    }

    public void setStarter(boolean starter) {
        isStarter = starter;
    }

    public boolean isSubbed() {
        return isSubbed;
    }

    public void setSubbed(boolean subbed) {
        isSubbed = subbed;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }
}
