package medium.p18;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                int p = j + 1;
                int k = nums.length - 1;

                while (p < k) {
                    int tmp = nums[i] + nums[j] + nums[p] + nums[k];
                    if (tmp == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[p], nums[k]);

                        String key = "" + nums[i] + "#" + nums[j] + "#" + nums[p] + "#" + nums[k];

                        if (!set.contains(key)) {
                            result.add(list);
                        }
                        set.add(key);
                        p++;
                        k--;
                    } else if (tmp > target) {
                        k--;
                    } else {
                        p++;
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0), equalTo(Lists.newArrayList(
                Lists.newArrayList(-2, -1, 1, 2),
                Lists.newArrayList(-2, 0, 0, 2),
                Lists.newArrayList(-1, 0, 0, 1))));
    }
}
