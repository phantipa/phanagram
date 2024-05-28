package com.phantipa.phanagram.services;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnagramServiceTest {

    public static final String[] WORDS = new String[]{
            "øl",
            "lø",
            "alt",
            "tal",
            "tal",
            "tall"
    };

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AnagramService anagramService;
    @Before
    public void setUp() throws Exception {
        anagramService = new AnagramService();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void findAnagrams() {
        Map<String, List<String>> anagramMap = anagramService.findAnagrams(WORDS);

        assertTrue(anagramMap.containsKey("lø"));
        assertTrue(anagramMap.containsKey("alt"));
        assertTrue(anagramMap.containsKey("allt"));

        List<String> list1 = anagramMap.get("lø");
        List<String> list2 = anagramMap.get("alt");
        List<String> list3 = anagramMap.get("allt");

        assertEquals(Arrays.asList("øl", "lø"), list1);
        assertEquals(Arrays.asList("alt", "tal", "tal"), list2);
        assertEquals(Arrays.asList("tall"), list3);

    }

    @Test
    public void testPrintAnagramList() {
        Map<String, List<String>> anagramMap = new HashMap<>();
        anagramMap.put("lø", Arrays.asList("øl", "lø"));
        anagramMap.put("alt", Arrays.asList("alt", "tal"));

        anagramService.printAnagramList(anagramMap);

        String expectedOutput = "[alt, tal]\n" + "[øl, lø]\n";
        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n"); // Replace Windows line separators
        //expectedOutput = expectedOutput.replaceAll("\\r", "\n"); // Replace MacOS line separators

        String actualOutput = outContent.toString();

        // Normalize line separators
        actualOutput = actualOutput.replaceAll("\\r\\n", "\n");     // Replace Windows line separators
        //actualOutput = actualOutput.replaceAll("\\r", "\n"); // Replace MacOS line separators

        assertEquals(expectedOutput, actualOutput);
    }
}