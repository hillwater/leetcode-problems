package p204;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.BitSet;

import org.junit.Test;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        BitSet bitSet = new BitSet(n+1);
        bitSet.set(2, n);

        int index = 2;

        while (index >= 0) {
            int count = 2;
            while (index * count < n) {
                bitSet.set(index * count, false);
                count++;
            }

            index = bitSet.nextSetBit(index + 1);
        }

        return bitSet.cardinality();
    }

    @Test
    public void test() {
        assertThat(countPrimes(0), is(0));
        assertThat(countPrimes(1), is(0));
        assertThat(countPrimes(2), is(0));
        assertThat(countPrimes(3), is(1));
        assertThat(countPrimes(20), is(8));
    }
}
