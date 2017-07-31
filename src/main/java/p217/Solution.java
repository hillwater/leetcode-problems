package p217;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int value : nums) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(containsDuplicate(new int[] { 1, 2, 3, 3, 4, 5 }), is(true));
        assertThat(containsDuplicate(new int[] { 1, 2, 3, 4, 5 }), is(false));
    }
}
