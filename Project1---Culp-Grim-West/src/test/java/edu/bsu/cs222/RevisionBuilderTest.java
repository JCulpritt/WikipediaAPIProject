package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionBuilderTest {
    @Test
    public void emptyTimestampArrayListTest() {
        RevisionBuilder builder = new RevisionBuilder();
        Assertions.assertEquals(new ArrayList<>(), builder.timestampArrayList);
    }

    @Test
    public void fullTimestampArrayListTest() throws IOException {
        RevisionBuilder builder = new RevisionBuilder();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> result = builder.makeArrayListOfKeywordTDD("timestamp",testDataStream);
        Assertions.assertEquals("2023-09-07T18:34:43Z", result.getFirst());
    }
    @Test
    public void fullUserArrayListTest() throws IOException {
        RevisionBuilder builder = new RevisionBuilder();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> result = builder.makeArrayListOfKeywordTDD("user",testDataStream);
        Assertions.assertEquals("Miklogfeather", result.getFirst());
    }

    @Test
    public void redirectParsedStringTest() throws IOException {
        RevisionBuilder builder = new RevisionBuilder();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String result = builder.makeRedirectStringTDD(testDataStream);
        Assertions.assertEquals("Frank Zappa", result);
    }
}
