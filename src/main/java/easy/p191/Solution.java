package easy.p191;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming
 * weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function
 * should return 3.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0;i<32;i++) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }

    @Test
    public void test() {
        assertThat(hammingWeight(11), is(3));
        assertThat(hammingWeight(1 << 20), is(1));
        assertThat(hammingWeight(0), is(0));
        assertThat(hammingWeight(0x8000), is(1));
    }
}
