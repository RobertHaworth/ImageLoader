package com.example.rhaworth.imageloader;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RHaworth on 4/14/17.
 */

public class ImageSearchResult extends Object {

    private JSONObject item;
    public String imageURL;
    public String thumbnailURL;
    public String title;

    public Integer thumbnailWidth;
    public Integer thumbnailHeight;

    public ImageSearchResult(JSONObject item) {
        this.item = item;

        JSONObject imageDict;
        try {
            title = item.getString("title");
            imageURL = item.getString("link");

            imageDict = item.getJSONObject("image");
            thumbnailURL = imageDict.getString("thumbnailLink");
            thumbnailWidth = imageDict.getInt("thumbnailWidth");
            thumbnailHeight = imageDict.getInt("thumbnailHeight");
        } catch (JSONException exception) {
            Log.d("ImageSearchResult", "invalid unwrapping of ImageSearchResult object");
        }
    }

    @Override
    public String toString() {
        return "Image Search Result: "
                    + "\n\ttitle: " + title
                    + "\n\timageURL: " + imageURL
                    + "\n\tthumbnailURL: " + thumbnailURL
                        + "\n\t\tthumbnailWidth: " + thumbnailWidth
                        + "\n\t\tthumbnailHeight: " + thumbnailHeight + "\n";
    }
}

//"kind": "customsearch#result",
//        "title": "Faces of Foxes: Photographer Proves That Every Fox Has Different ...",
//        "htmlTitle": "Faces of Foxes: Photographer Proves That Every <b>Fox<\/b> Has Different ...",
//        "link": "http:\/\/static.boredpanda.com\/blog\/wp-content\/uploads\/2016\/07\/fox-faces-roeselien-raimond-red-fox.jpg",
//        "displayLink": "www.boredpanda.com",
//        "snippet": "Faces of Foxes: Photographer Proves That Every Fox Has Different ...",
//        "htmlSnippet": "Faces of Foxes: Photographer Proves That Every <b>Fox<\/b> Has Different ...",
//        "mime": "image\/jpeg",
//        "image": {
//        "contextLink": "http:\/\/www.boredpanda.com\/faces-of-foxes-roeselien-raimond\/",
//        "height": 880,
//        "width": 880,
//        "byteSize": 210200,
//        "thumbnailLink": "https:\/\/encrypted-tbn0.gstatic.com\/images?q=tbn:ANd9GcSfBhd2DYODXRHpu513_WcqhTL_WUG9p3QndRIm4Gm47D8WK76IUE0MrFQ-",
//        "thumbnailHeight": 146,
//        "thumbnailWidth": 146
//        }