package apcsa.githubtrack;

// Implement your CString class here

public class CString {
    private char[] string;

    public CString(String s) {
        string = s.toCharArray();
    }

    public char get(int i) {
        return string[i];
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
}