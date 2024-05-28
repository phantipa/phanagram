package com.phantipa.phanagram.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class FileServiceTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private FileService fileService;

    @Before
    public void setUp() throws Exception {
        fileService = new FileService();
    }

    @Test
    public void testReadFileToStringArray_NonEmptyFile() throws IOException {
        String fileName = "src/test/resources/test.txt";
        String[] words = fileService.readFileToStringArray(fileName);

        // Read the file directly to compare
        Set<String> expectedWordsList = new HashSet<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                expectedWordsList.add(line.trim());
            }
        }

        String[] expectedWords = new String[expectedWordsList.size()];
        expectedWords = expectedWordsList.toArray(expectedWords);

        System.out.println("expectedWords");

        for (String word : expectedWords) {
            System.out.println(word);
        }

        System.out.println("words");
        for (String word : words) {
            System.out.println(word);
        }

        assertNotNull(words);
        assertArrayEquals(expectedWords, words);
    }

    @Test
    public void testReadFileToStringArray_EmptyFile() throws IOException {
        File tempFile = temporaryFolder.newFile("empty.txt");

        String[] words = fileService.readFileToStringArray(tempFile.getAbsolutePath());

        assertNotNull(words);
        assertArrayEquals(new String[0], words);
    }


    @Test(expected = IOException.class)
    public void testReadFileToStringArray_IOException() throws IOException {
        String fileName = "non_existent_file.txt";

        fileService.readFileToStringArray(fileName);
    }
}