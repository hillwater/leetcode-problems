package p119;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0) {
            return result;
        }

        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);

            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(getRow(3), equalTo(Lists.newArrayList(1, 3, 3, 1)));
        assertThat(getRow(4), equalTo(Lists.newArrayList(1, 4, 6, 4, 1)));
    }
}
