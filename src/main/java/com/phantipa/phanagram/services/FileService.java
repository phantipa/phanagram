package com.phantipa.phanagram.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {

    private static final Logger LOGGER = Logger.getLogger(FileService.class.getName());

    public String[] readFileToStringArray(String fileName) throws IOException {
        // [3] Ensure that each element is unique and eliminates duplicates
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName),
                        StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line is not empty before adding to the list
                if (!line.trim().isEmpty()) {
                    uniqueWords.add(line.trim());
                }
            }
        } catch (IOException e) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "Error reading file: " + fileName, e);
            }
            throw e;
        }

        // Convert List to Array
        return uniqueWords.toArray(new String[0]);
    }
}