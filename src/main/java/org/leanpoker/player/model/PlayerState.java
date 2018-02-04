package org.leanpoker.player.model;

import java.util.ArrayList;

/**
 * Created by mindwork on 04.02.18.
 */
public class PlayerState {
    public int id;
    public  String name;
    public  String status;
    public String version;
    public int stack;
    public int bet;
    public ArrayList <HoleCard> hole_cards;
}
