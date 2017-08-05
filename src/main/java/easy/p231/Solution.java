package easy.p231;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n>0) && (n & (n-1)) == 0;
    }

    @Test
    public void test() {
        assertThat(isPowerOfTwo(0), is(false));
        assertThat(isPowerOfTwo(1), is(true));
        assertThat(isPowerOfTwo(4), is(true));
        assertThat(isPowerOfTwo(1024), is(true));
        assertThat(isPowerOfTwo(1000), is(false));
    }
}
