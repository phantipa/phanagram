package com.phantipa.phanagram.services;

import java.util.*;

public class AnagramService {

    public Map<String, List<String>> findAnagrams(String[] words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            // Sort the word to create a key
            System.out.println("word=" + word);

            char[] charArray = word.toCharArray();
            System.out.println("charArray1=" + Arrays.toString(charArray));

            Arrays.sort(charArray);
            System.out.println("charArray2=" + Arrays.toString(charArray));

            String sortedKey = new String(charArray);
            System.out.println("sortedKey=" + sortedKey);
            System.out.println("------------");

            // Check if the key exists in the map
            if (!anagramMap.containsKey(sortedKey)) {
                // If not, create a new list and put it in the map
                anagramMap.put(sortedKey, new ArrayList<>());
            }
            // Add the word to the corresponding list in the map
            anagramMap.get(sortedKey).add(word);
        }

        return anagramMap;
    }

    public void printAnagramList(Map<String, List<String>> anagramMap) {
        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            // Print anagram that has one or several anagrams in the list.
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue());
            }
        }
    }
}