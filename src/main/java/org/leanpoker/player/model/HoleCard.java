package org.leanpoker.player.model;

import org.leanpoker.player.Player;

/**
 * Created by mindwork on 04.02.18.
 */

public class HoleCard implements Comparable {
    public String rank;
    public   String suit;

    @Override
    public int compareTo(Object o) {
        if(Player.getIndexRank(this.rank) < Player.getIndexRank(((HoleCard)o).rank))
            return -1;
        else if(Player.getIndexRank(this.rank) > Player.getIndexRank(((HoleCard)o).rank))
            return 1;
        else return 0;
    }
}
