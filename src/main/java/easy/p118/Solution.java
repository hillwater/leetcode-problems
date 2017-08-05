package easy.p118;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousList = result.get(i - 1);

            List<Integer> list = new ArrayList<>();

            list.add(1);

            for (int j = 1; j < i; j++) {
                list.add(previousList.get(j - 1) + previousList.get(j));
            }

            list.add(1);

            result.add(list);
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(generate(5), equalTo(Lists.newArrayList(
                Lists.newArrayList(1),
                Lists.newArrayList(1, 1),
                Lists.newArrayList(1, 2, 1),
                Lists.newArrayList(1, 3, 3, 1),
                Lists.newArrayList(1, 4, 6, 4, 1))));
    }
}
