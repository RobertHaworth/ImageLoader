package com.example.rhaworth.imageloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by RHaworth on 5/8/17.
 */

public class SearchResult {

    private JSONObject backingData;
    private Integer startIndex;
    private Integer count;
    public ArrayList<ImageSearchResult> imageResults = new ArrayList<ImageSearchResult>();

    public SearchResult() {
        try {
            backingData = new JSONObject("no_value");
        } catch (JSONException exception) {
            Log.d("SearchResult", "this should never occur. invalid creation of placeholder JSON object");
        }
    }

    public SearchResult(JSONObject data) {
        if (data == null) {
            return;
        }

        backingData = data;
        onDataUpdate();
    }

    protected void setBackingData(JSONObject data) {
        backingData = data;
        onDataUpdate();
    }

    private void onDataUpdate() {
        JSONObject queries;
        JSONObject queryDictionary;
//        JSONObject nextPageDictionary;
        JSONArray items;
        imageResults.clear();
        try {
            items = backingData.getJSONArray("items");
            queries = backingData.getJSONObject("queries");
            queryDictionary = queries.getJSONArray("request").getJSONObject(0);
//            nextPageDictionary = queries.getJSONArray("nextPage").getJSONObject(0);
            startIndex = queryDictionary.getInt("startIndex");
            count = queryDictionary.getInt("count");

            for (int index = 0; index < items.length(); index++) {
                imageResults.add(new ImageSearchResult(items.getJSONObject(index)));
            }

        } catch (JSONException exception) {
            Log.d("SearchResult", "Invalid unwrapping of Search Result object");
        }
    }

    @Override
    public String toString() {
        Object[] value = imageResults.toArray();

        return "SearchResult object: "
                    + "\n\tstartIndex: " + startIndex
                    + "\n\tcount: " + count
                    + "\n\tresults: " + "\n\t " + Arrays.deepToString(value);
    }
}
