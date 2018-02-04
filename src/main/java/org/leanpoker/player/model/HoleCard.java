package org.leanpoker.player.model;

import org.leanpoker.player.Player;

/**
 * Created by mindwork on 04.02.18.
 */

public class HoleCard implements Comparable {
    public String rank;
    public String suit;

    public HoleCard() {
    }

    public HoleCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Object o) {
        if (Player.getIndexRank(this.rank) < Player.getIndexRank(((HoleCard) o).rank))
            return -1;
        else if (Player.getIndexRank(this.rank) > Player.getIndexRank(((HoleCard) o).rank))
            return 1;
        else return 0;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
