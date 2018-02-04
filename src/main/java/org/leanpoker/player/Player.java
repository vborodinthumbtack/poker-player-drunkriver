package org.leanpoker.player;

import com.google.gson.JsonElement;

import org.leanpoker.player.model.GameState;

import java.util.Map;

public class Player {

    static final String VERSION = "WE ARE THE BEST";

    public static int betRequest(GameState request) {

        return (int)Math.random() * 3;
    }

    public static void showdown(JsonElement game) {

    }
}
