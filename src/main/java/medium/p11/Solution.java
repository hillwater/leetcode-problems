package medium.p11;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int beginHeight = 0;

        for (int i = 0; i < height.length; i++) {
            int hi = height[i];
            if (hi <= beginHeight) {
                continue;
            }

            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(hi, height[j]) * (j - i);

                if (max < area) {
                    max = area;
                    beginHeight = hi;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(maxArea(new int[] { 1, 2, 3, 4 }), is(4));
        assertThat(maxArea(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 }), is(12));

        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }

        assertThat(maxArea(array), is(56250000));

    }
}
