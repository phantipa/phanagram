package com.phantipa.phanagram.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class FileService {

    public String[] readFileToStringArray(String fileName) {
//        List<String> wordList = new ArrayList<>();
        Set<String> wordList = new HashSet<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName),
                        StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line is not empty before adding to the list
                if (!line.trim().isEmpty()) {
                    wordList.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert List to Array
        return wordList.toArray(new String[0]);
    }
}