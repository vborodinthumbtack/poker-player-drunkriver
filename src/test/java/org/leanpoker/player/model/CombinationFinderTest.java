package org.leanpoker.player.model;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mindwork on 04.02.18.
 */
public class CombinationFinderTest {


    @Test
    @Ignore
    public void getFinestCombinationPair() throws Exception {
        List<HoleCard> testCards = Arrays.asList(
                new HoleCard("10", "spades"),
                new HoleCard("10", "hearts"),
                new HoleCard("A", "spades"));

        assertEquals(CombinationFinder.getFinestCombination(testCards), 1) ;
    }

}