package org.rapidpm.demo.max.rechnen;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by sven on 15.03.15.
 */
public class RechenaufgabenTest {

    @Test
    public void test001() throws Exception {

        for (int i = 0; i < 100; i++) {
            int[] ints = new Random().ints(0, 5).limit(2).toArray();
            int result = ints[0] + ints[1];
            Assert.assertTrue(result >= 0);
            Assert.assertTrue(result < 11);
        }


    }
}
