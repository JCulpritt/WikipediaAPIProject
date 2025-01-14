package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionBuilder {
    ArrayList<String> timestampArrayList = new ArrayList<>();
    ArrayList<String> userArrayList = new ArrayList<>();

    String redirectString;
    ArrayList<Revision> revisionList = new ArrayList<>();

    protected void buildRevisions() throws IOException {
        timestampArrayList = makeArrayListOfKeyword("timestamp");
        userArrayList =  makeArrayListOfKeyword("user");
        redirectString = makeRedirectString();
        for(int i = 0; i < timestampArrayList.size(); i++){
            Revision revisionObject = new Revision(userArrayList.get(i), timestampArrayList.get(i));
            revisionObject.setRedirect(redirectString);
            revisionList.add(revisionObject);

        }
    }
    protected ArrayList<String> makeArrayListOfKeyword(String keyword) throws IOException {
        RevisionParser parser = new RevisionParser();
        JSONArray keywordJsonArray = parser.makeJSONArray(keyword);
        return parser.parse(keywordJsonArray);
    }

    protected String makeRedirectString() throws IOException {
        RevisionParser parser = new RevisionParser();
        JSONArray redirectJsonArray = parser.makeJSONArray("to");
        return parser.parseRedirect(redirectJsonArray);
    }
    protected StringBuilder getAllRevisions(){
        StringBuilder revisions = new StringBuilder();
        for(Revision revision : revisionList) {
            revisions.append(revision).append("\n");
        }
        return revisions;
    }


    //These methods below are used for testing only and take in a Test InputStream
    protected ArrayList<String> makeArrayListOfKeywordTDD(String keyword, InputStream testStream) throws IOException {
        RevisionParser parser = new RevisionParser();
        JSONArray keywordJsonArray = parser.makeJSONArrayTDD(keyword, testStream);
        return parser.parse(keywordJsonArray);
    }
    protected String makeRedirectStringTDD(InputStream testStream) throws IOException {
        RevisionParser parser = new RevisionParser();
        JSONArray redirectJsonArray = parser.makeJSONArrayTDD("to", testStream);
        return parser.parseRedirect(redirectJsonArray);
    }


}
