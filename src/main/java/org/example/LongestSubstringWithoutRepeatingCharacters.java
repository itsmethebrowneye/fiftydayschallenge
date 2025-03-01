package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int count = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimal(s);
        System.out.println("Longest Substring Without Repeating Characters for String: " + s + " " + "is " + count);
    }

    /**
     * @param s - input string with repeating or non-repeating characters
     * @return - longest substring length without repeating characters
     * time complexity - o(n)
     * space complexity - 0(256) - new array - extra space
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int max = 0; // initialise max as 0
        char[] inputString = s.toCharArray(); // convert the given input string to characters array

        for (int i = 0; i < inputString.length; i++) {  // iterate the characters array
            int[] hashArray = new int[255]; // declare an array of length 255 similar ASCII
            int len = 0; // temporary substring length is initialised to 0
            for (int j = i; j < inputString.length; j++) { // iterate the substring array with first character from i
                int value = inputString[j]; // retrieve the character ASCII value (integer)
                if (hashArray[value] == 1)
                    break; // check if the ASCII value of the character in the array is 1. If 1, then it is already visisted, so break
                else {
                    len = j - i + 1; // if not visited, calculate the substring length
                    max = Math.max(max, len); // assign the new max
                    hashArray[value] = 1; // visit the ASCII value of the character in the array. (set to 1)
                }
            }
        }
        return max; // return the max finally
    }

    /**
     * @param s- input string with repeating or non-repeating characters
     * @return - longest substring length without repeating characters
     * approach - sliding window with 2 pointers
     */
    public int lengthOfLongestSubstringOptimal(String s) {
        char[] inputString = s.toCharArray(); // abcabcbb
        Map<Character, Integer> map = new HashMap<>();
        int length = inputString.length;
        int max = 0;
        int l = 0;
        for (int r = 0; r < length; r++) {
            if (map.containsKey(inputString[r]) && map.get(inputString[r]) >= l) {
                l = map.get(inputString[r]) + 1;
            }
            map.put(inputString[r], r);
            int len = r - l + 1;
            max = Math.max(max, len);
        }
        return max;
    }

}

