package com.phantipa.phanagram;

import com.phantipa.phanagram.services.AnagramService;
import com.phantipa.phanagram.services.FileService;

import java.util.List;
import java.util.Map;

public class Main {

    public static final String FILE_NAME = "src/main/resources/static/words-utf8.txt";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        AnagramService anagramService = new AnagramService();

        // Read words from the file
        String[] words = fileService.readFileToStringArray(FILE_NAME);

        // Find anagrams
        Map<String, List<String>> anagramMap = anagramService.findAnagrams(words);

        // Print anagram groups
        anagramService.printAnagramList(anagramMap);
    }
}