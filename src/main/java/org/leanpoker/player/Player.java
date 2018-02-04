package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.leanpoker.player.model.GameState;
import org.leanpoker.player.model.HoleCard;
import org.leanpoker.player.model.PlayerState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {

    static final String VERSION = "WE ARE THE BEST";
    public static String[] listSuits = {"clubs", "spades", "hearts", "diamonds"};
    public static String[] listRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static int getCountPlayers(PlayerState[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (!players[i].status.equals("out"))
                count++;
        }
        return count;
    }

    static int SUIT = 100;
    static int THREE = 90;
    static int CARE = 1000;
    static int TWO = 50;
    static int STREET = 100;

    public static int getPattetialHand(List<HoleCard> holeCards) {
        int[] countRanks = new int[13];
        int[] countSuits = new int[4];
        for (int i = 0; i < holeCards.size(); i++) {
            int indxR = getIndexRank(holeCards.get(i).rank);
            int indxS = getIndexSuit(holeCards.get(i).suit);
            countRanks[indxR]++;
            countSuits[indxS]++;

        }
        for (int i = 0; i < 4; i++) {
            if (countSuits[i] == 4)
                return SUIT;
        }
        int countStreet = 0;
        for(int i =0; i < countRanks.length; i++){
            if(countRanks[i] == 0)
                countStreet = 0;
            else
                countStreet++;
            if(countStreet == 4)
                return STREET;
        }
        return 0;
    }

    public static int getHand(List<HoleCard> holeCards) {
        int[] countRanks = new int[13];
        int[] countSuits = new int[4];


        for (int i = 0; i < holeCards.size(); i++) {
            int indxR = getIndexRank(holeCards.get(i).rank);
            int indxS = getIndexSuit(holeCards.get(i).suit);
            countRanks[indxR]++;
            countSuits[indxS]++;

        }
        for (int i = 0; i < 4; i++) {
            if (countSuits[i] >= 5)
                return SUIT;
        }
        for (int i = 0; i < 13; i++) {
            if (countRanks[i] == 4)
                return CARE;
        }
        int countStreet = 0;
        for(int i =0; i < countRanks.length; i++){
            if(countRanks[i] == 0)
                countStreet = 0;
            else
                countStreet++;
            if(countStreet == 5)
                return STREET;
        }
        for (int i = 0; i < 13; i++) {
            if (countRanks[i] == 3)
                return THREE;

        }
        for (int i = 0; i < 13; i++) {
            if (countRanks[i] == 2)
                return TWO;
        }
        return 0;
    }

    public static int betRequest(GameState game) {
        try {
            ArrayList<HoleCard> hole_cards = game.players[game.in_action].hole_cards;
            List<HoleCard> list = new ArrayList<HoleCard>();
            list.addAll(hole_cards);
            list.addAll(game.community_cards);

            Collections.sort(list, new Comparator<HoleCard>() {
                @Override
                public int compare(HoleCard o1, HoleCard o2) {
                    if (getIndexRank(o1.rank) == getIndexRank(o2.rank))
                        return 0;
                    else if (getIndexRank(o1.rank) > getIndexRank(o2.rank))
                        return 1;
                    else
                        return -1;
                }
            });


            if (game.getStage() == 0) {
                if (hole_cards.get(0).rank.equals(hole_cards.get(1).rank))
                    return game.getAllIn();
                else if (getIndexRank(hole_cards.get(0).rank) >= 9 || getIndexRank(hole_cards.get(1).rank) >= 9)
                    return game.getCall();
                else if (hole_cards.get(0).suit.equals(hole_cards.get(1).suit))
                    return game.getCall();
                else if (game.getCall() < 5)
                    return game.getCall();
            } else {
                int comb = getHand(list);
                if (comb == CARE || comb == SUIT)
                    return game.getAllIn();
                else if (comb == THREE)
                    return game.getCall() + 10;
                else if (comb != 0)
                    return game.getCall();
                else if (game.getStage() != 3) {
                    int pat = getPattetialHand(list);
                    if (pat != 0)
                        return game.getCall();
                }
            }

            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getIndexRank(String r) {
        for (int i = 0; i < listRanks.length; i++) {
            if (r.equals(listRanks[i]))
                return i;
        }
        return 0;
    }

    public static int getIndexSuit(String r) {
        for (int i = 0; i < listSuits.length; i++) {
            if (r.equals(listSuits[i]))
                return i;
        }
        return 0;
    }

    public static void showdown(JsonElement game) {

    }
}
