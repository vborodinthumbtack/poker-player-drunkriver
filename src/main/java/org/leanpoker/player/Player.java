package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.leanpoker.player.model.GameState;
import org.leanpoker.player.model.HoleCard;

public class Player {

    static final String VERSION = "WE ARE THE BEST";

    public static int betRequest(GameState game) {
        HoleCard[] hole_cards = game.players[game.in_action].hole_cards;
        if (hole_cards[0].rank.equals(hole_cards[1].rank))
            return 1000;
        else
            return 0;
    }

    public static void showdown(JsonElement game) {

    }
}
