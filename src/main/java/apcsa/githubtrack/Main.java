package apcsa.githubtrack;

import java.io.*;
import java.util.Scanner;

// Implement your main application logic here

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("/home/owner/Documents/VSCode/AP CSA/assn06-char-cryptography-JeheramyP/src/main/resources/secretMessage.txt");
        Scanner scanner = new Scanner(f);
        String[] words = scanner.nextLine().split(" ");
        CString[] cswords = new CString[words.length];
        for (int i = 0; i < words.length; i++) {
            cswords[i] = new CString(words[i]);
        }
        scanner.close();

        for (int i = 0; i < cswords.length; i++) {
            cswords[i] = CStringUtil.decrypt(cswords[i]);
        }

        int max = 0;
        for (int i = 0; i < cswords.length; i++) {
            for (char c : cswords[i].get()) {
                int val = (int) c;
                if (val > max) {
                    max = val;
                }
            }
        }
        int d = max - 60;
        rotate(cswords, d);

        for (CString csword : cswords) {
            System.out.print(csword.toString() + " ");
        }
    }

    public static void rotate(CString[] cswords, int d) {
        for (int i = 0; i < d; i++) {
            CString first = cswords[0];
            for (int j = 0; j < cswords.length - 1; j++) {
                cswords[j] = cswords[j+1];
            }
            cswords[cswords.length - 1] = first;
        }
    }
}