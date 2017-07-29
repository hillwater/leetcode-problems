package p13;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('X', 10);
        romanMap.put('C', 100);
        romanMap.put('M', 1000);
        romanMap.put('V', 5);
        romanMap.put('L', 50);
        romanMap.put('D', 500);

        int result = 0;

        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));

            if (prev > current) {
                result -= current;
                prev = 0;
            } else {
                result += current;
                prev = current;
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(romanToInt("X"), is(10));
        assertThat(romanToInt("IX"), is(9));
        assertThat(romanToInt("XIX"), is(19));
        assertThat(romanToInt("XX"), is(20));
        assertThat(romanToInt("MCMLXXX"), is(1980));
    }
}
