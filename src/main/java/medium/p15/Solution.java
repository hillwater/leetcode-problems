package medium.p15;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            int sum = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int tmp = nums[j] + nums[k];
                if (tmp == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);

                    String key = "" + nums[i] + "#" + nums[j] + "#" + nums[k];

                    if (!set.contains(key)) {
                        result.add(list);
                    }
                    set.add(key);
                    j++;
                    k--;
                } else if (tmp > sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }), equalTo(Lists.newArrayList(
                Lists.newArrayList(-1, -1, 2),
                Lists.newArrayList(-1, 0, 1))));
    }
}
