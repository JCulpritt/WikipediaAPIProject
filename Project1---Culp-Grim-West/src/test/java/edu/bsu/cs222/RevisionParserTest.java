package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class RevisionParserTest {
    @Test

    public void testParseTimestamp() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray jsonArray = parser.makeJSONArrayTDD("timestamp", testDataStream);
        ArrayList<String> timeStamp = parser.parse(jsonArray);
        ArrayList<String> testTimestamp = new ArrayList<>(Arrays.asList("2023-09-07T18:34:43Z", "2023-09-07T17:21:48Z", "2023-09-02T15:06:03Z", "2023-09-02T15:05:04Z"));
        Assertions.assertTrue(timeStamp.containsAll(testTimestamp));
    }

    @Test
    public void testParseUser() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray jsonArray = parser.makeJSONArrayTDD("user", testDataStream);
        ArrayList<String> users = parser.parse(jsonArray);
        ArrayList<String> testUser = new ArrayList<>(Arrays.asList("Miklogfeather", "ModernDayTrilobite", "Freefry", "Freefry"));
        Assertions.assertTrue(users.containsAll(testUser));
    }

    @Test
    public void testParseRedirect() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray jsonArray = parser.makeJSONArrayTDD("to", testDataStream);
        String redirects = parser.parseRedirect(jsonArray);
        Assertions.assertEquals("Frank Zappa", redirects);
    }


}
