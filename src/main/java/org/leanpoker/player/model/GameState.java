package org.leanpoker.player.model;

import java.util.ArrayList;

/**
 * Created by mindwork on 04.02.18.
 */

public class GameState {

    public String tournament_id;
    public String game_id;
    public int round;
    public int bet_index;
    public int small_blind;
    public int current_buy_in;
    public int pot;
    public int minimum_raise;
    public int dealer;
    public int orbits;
    public int in_action;
    public PlayerState [] players;
    public ArrayList<HoleCard> community_cards;
    public  int getCall(){
        return  current_buy_in - players[in_action].bet;
    }

    public  int getAllIn(){
        return players[in_action].stack;
    }
    public int getStage(){
        if(community_cards.size() == 0)
            return 0;
        else if(community_cards.size() == 3)
            return 1;
        else if(community_cards.size() == 4)
            return 2;
        else
            return 3;
    }
}
