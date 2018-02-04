package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.leanpoker.player.model.GameState;
import org.leanpoker.player.model.HoleCard;

public class Player {

    static final String VERSION = "WE ARE THE BEST";
    public  static String [] listSuits = {"clubs", "spades", "hearts", "diamonds"};
    public  static String [] listRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static int betRequest(GameState game) {
        HoleCard[] hole_cards = game.players[game.in_action].hole_cards;
        if (hole_cards[0].rank.equals(hole_cards[1].rank))
            return 1000;
        else if(getIndexRank(hole_cards[0].rank) >= 9)
            return 1000;
        else
            return 0;
    }
    public  static  int getIndexRank(String r){
        for (int i = 0; i < listRanks.length; i++){
            if(r.equals(listRanks[i]))
                return i;
        }
        return 0;
    }
    public static void showdown(JsonElement game) {

    }
}
