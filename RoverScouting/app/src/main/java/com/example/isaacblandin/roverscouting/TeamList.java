package com.example.isaacblandin.roverscouting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class used to allow teams to be added more easily to the list and map
 */
public class TeamList {

    /**
     * An array of teams
     */
    public static final List<TeamItem> ITEMS = new ArrayList<TeamItem>();

    public static final Map<String, TeamItem> ITEM_MAP = new HashMap<String, TeamItem>();

    /**
     * adds a team object to the team list and the map
     *
     * @param item object to be added
     */
    public static void addItem(TeamItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

}
