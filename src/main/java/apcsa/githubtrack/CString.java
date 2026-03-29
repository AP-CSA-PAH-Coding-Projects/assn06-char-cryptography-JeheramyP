package apcsa.githubtrack;

// Implement your CString class here

public class CString {
    private char[] string;

    public CString(String s) {
        string = s.toCharArray();
    }

    public CString(char[] arr) {
        string = arr;
    }

    public CString(int[] nums) {
        string = new char[nums.length];
        for (int i = 0; i < nums.length; i++) {
            string[i] = (char) nums[i];
        }
    }

    public char[] get() {
        return string;
    }

    public int length() {
        return string.length;
    }

    public void reverse() {
        char[] newStr = new char[string.length];
        for (int i = string.length-1; i >= 0; i--) {
            newStr[string.length-1-i] = string[i];
        }
        string = newStr;
    }

    public void sortAscending() {
        for (int i = 0; i < string.length-1; i++) {
            int minI = i;
            for (int j = i+1; j < string.length; j++) {
                if (string[j] < string[minI]) {
                    minI = j;
                }
            }
            char temp = string[i];
            string[i] = string[minI];
            string[minI] = temp;
        }
        
    }

    public void sortDescending() {
        for (int i = 1; i < string.length; i++) {
            char curr = string[i];
            int j = i - 1;
            while (j >= 0 && string[j] < curr) {
                string[j+1] = string[j];
                j--;
            }
            string[j+1] = curr;
        }
        
    }

    public String toString() {
        return new String(string);
    }
}