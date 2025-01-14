package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class ConnectToWiki {
    static String userInput = " ";

    //Deprecated sample code
    @SuppressWarnings("deprecation")
    protected URLConnection connectToWikipedia() throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (garrett.grim@bsu.edu & joseph.culp@bsu.edu)");
        connection.connect();
        return connection;
    }

    protected InputStream URLtoInputStream(URLConnection connection) throws IOException {
        return connection.getInputStream();
    }


}