package p66;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0) {
                    digits[i] = 0;
                } else {
                    digits[i - 1]++;
                    digits[i] = 0;
                }
            } else {
                break;
            }
        }

        if (digits[0] == 0) {
            int[] tempResult = new int[digits.length + 1];
            tempResult[0] = 1;
            for (int i = 1; i < tempResult.length; i++) {
                tempResult[i] = 0;
            }
            return tempResult;
        } else {
            return digits;
        }
    }

    @Test
    public void test() {
        assertThat(plusOne(new int[] { 1, 2, 1 }), equalTo(new int[] { 1, 2, 2 }));
        assertThat(plusOne(new int[] { 9, 9, 9, 9, 9 }), equalTo(new int[] { 1, 0, 0, 0, 0, 0 }));
    }
}
