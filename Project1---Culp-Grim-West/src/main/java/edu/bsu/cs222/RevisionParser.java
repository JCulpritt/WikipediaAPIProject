package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {

    protected JSONArray makeJSONArray(String keyword) throws IOException {
        ConnectToWiki connect = new ConnectToWiki();
        InputStream inputStream = connect.URLtoInputStream(connect.connectToWikipedia());
        return JsonPath.read(inputStream, "$.." + keyword);
    }


    //THIS CLASS IS USED FOR TESTING PURPOSES ONLY
    protected JSONArray makeJSONArrayTDD(String keyword, InputStream inputStream) throws IOException {
        return JsonPath.read(inputStream, "$.." + keyword);
    }


    protected ArrayList<String> parse(JSONArray jsonArray) {
        ArrayList<String> revisionDetails = new ArrayList<>();
        for (Object parsedItem : jsonArray) {
            revisionDetails.add(parsedItem.toString());
        }
       return revisionDetails;
    }

    protected String parseRedirect(JSONArray jsonArray) {
        String redirect = null;
        if (!jsonArray.isEmpty()) {
            redirect = jsonArray.getFirst().toString();
        }
        return redirect;
    }


}
