package apcsa.githubtrack;

import java.util.Arrays;
import java.util.ArrayList;

// Implement your CStringUtil class here

public class CStringUtil {

    public static boolean isPalindrome(CString s) {
        if (s.length() == 1) {
            return true;
        }
        int spaces = 0;
        for (char c : s.get()) {
            if (c == ' ') {
                spaces++;
            }
        }
        CString cleaned = new CString(new char[s.length() - spaces]);
        int index = 0;
        for (char c : s.get()) {
            if (c == ' ') {
                continue;
            }
            cleaned.get()[index] = Character.toLowerCase(c);
            index++;
        }
        CString temp = new CString(cleaned.get());
        cleaned.reverse();
        return Arrays.equals(temp.get(), cleaned.get());
    }

    public static int[] toNumerical(CString str, int offset) {
        int[] numerical = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            numerical[i] = (int) (str.get()[i] + offset);
        }
        return numerical;
    }

    public static int maxMirror(CString str) {
        int[] num = toNumerical(str, 0);
        return maxMirror(num);
    }

    public static int maxMirror(int[] num) {
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j >= 0; j--) {
                int length = 0;
                int left = i;
                int right = j;
                while (left < num.length && right >= 0 && num[left] == num[right]) {
                    length++;
                    left++;
                    right--;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public static int[] memeifyArray(int[] nums) {
        int[] result = new int[nums.length];
        ArrayList<Integer> sevens = new ArrayList<>();
        ArrayList<Integer> others = new ArrayList<>();
        for (int n : nums) {
            if (n == 7) {
                sevens.add(n);
            } else if (n != 6) {
                others.add(n);
            }
        }

        // add 6 and 7s in the right place
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                result[i] = 6;
                try {
                    result[i+1] = sevens.remove(0);
                } catch (Exception e) {
                    // no more 7s, do nothing
                }
                
            }
        }

        // add back others
        for (int i = 0; i < nums.length; i++) {
            if (result[i] == 0) {
                result[i] = others.remove(0);
            }
        }

        return result;
    }

    public static boolean nestedSequence(CString outer, CString inner) {
        if (inner.get().length == 0) {
            return true;
        }
        outer.sortAscending();
        inner.sortAscending();
        int[] out = toNumerical(outer, 0);
        int[] in = toNumerical(inner, 0);

        for (int i = 0; i < out.length; i++) {
            if (out[i] == in[0]) {
                for (int j = 0; j < in.length; j++) {
                    if (i + j < out.length && out[i + j] != in[j]) {
                        break;
                    }
                    if (j == in.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static CString decrypt(CString str) {
        int[] nums = toNumerical(str, 0);

        // count clumps
        int clumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                clumps++;
                while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }

        // shift ASCII values back by number of clumps
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= clumps;
        }

        CString result = new CString(nums);
        result.reverse();
        return result;
    }
}