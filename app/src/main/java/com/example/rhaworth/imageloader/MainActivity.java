package com.example.rhaworth.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView searchTextField;
    private Button searchButton;

    private RequestQueue queue;
    private String baseURL = "https://www.googleapis.com/customsearch/v1";
    private String apiKey = "AIzaSyB9hlqyZ3dztGQNC9zs8TUKFeTXoTeBres";
    private String cxID = "007607989949903216152:9vqzpf7ngoc";

    private RecyclerView imageRecyclerView;
    private GridLayoutManager layoutManager;

    private SearchResult result = new SearchResult(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchTextField = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        searchButton = (Button)findViewById(R.id.searchButton);
        imageRecyclerView = (RecyclerView) findViewById(R.id.imageRecyclerView);


        ImageAdapter adapter = new ImageAdapter(this, result);
        layoutManager = new GridLayoutManager(this, 4);

        imageRecyclerView.setHasFixedSize(true);
        imageRecyclerView.setLayoutManager(layoutManager);
        imageRecyclerView.setAdapter(adapter);





//        imageRecyclerView.setAdapter(adapter);
        queue = Volley.newRequestQueue(this);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchForImages();
            }
        });
    }


    private void searchForImages() {

        String searchString = searchTextField.getText().toString().replace(" ", "+");
        String requestURL = baseURL + "?key=" + apiKey + "&cx=" + cxID + "&searchType=image" + "&q=" + searchString;
        Log.d("searchForImages", "url to be used: " + requestURL);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("searchForImages", response.toString());

                result.setBackingData(response);
                ImageAdapter adapter = (ImageAdapter)imageRecyclerView.getAdapter();
                adapter.notifyDataSetChanged();
                Log.d("searchForImages", result.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error!", "Danger, danger Will Robinson!");
            }
        });

        queue.add(request);
    }

//    protected void showDetailActivity(String url) {
//        Intent newIntent = new Intent(this, ImageActivity.class);
//        newIntent.putExtra("url", url);
//        startActivity(newIntent);
//    }
}