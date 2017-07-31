package p278;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 */
public class Solution {
    int border;

    public boolean isBadVersion(int version) {
        return version >= border;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean flag = isBadVersion(mid);
            if (flag) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    @Test
    public void test() {
        border = 4;
        assertThat(firstBadVersion(10), is(4));
        assertThat(firstBadVersion(100), is(4));

        border = 99;
        assertThat(firstBadVersion(100), is(99));
    }
}
