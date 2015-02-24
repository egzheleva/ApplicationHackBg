/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallestsubstringcontainingthealphabet;

import java.util.Arrays;

/**
 *
 * @author eli
 */
public class SmallestSubstringContainingTheAlphabet {

        public static String sortingString(String az) {
        char[] a = az.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public boolean containsTheAlphabet(String string) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return sortingString(string).toLowerCase().contains(alphabet);
    }

    public String smallestSubstringContainingTheAlphabet(String string) {

        int minLength = string.length();
        String minString = "";

        String sub;
        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j <= string.length() - i; j++) {
                sub = string.substring(i, i + j);
                if (containsTheAlphabet(sub)) {
                    if (sub.length() < minLength) {
                        minLength = sub.length();
                        minString = sub;
                    }
                    //System.out.println(sub);

                }

            }
        }

        return minString;
    }
    public static void main(String[] args) {
        System.out.println(SmallestSubstringContainingTheAlphabet.sortingString("opqrstuvwxyz!*abcdefghijklmn"));
    }
    
}
