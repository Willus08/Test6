package posidenpalace.com.test6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Question1 extends AppCompatActivity {

    private static final String TAG = "question 1";
    JSONObject parrent;
    String Input = "{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 27}, {\"id\": 0, \"label\": \"Label 0\"}, null, {\"id\": 93}, {\"id\": 85}, {\"id\": 54}, null, {\"id\": 46, \"label\": \"Label 46\"}]}}";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        try {
            parseJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseJSON() throws JSONException {
        parrent = new JSONObject(Input);
        int sum =0;
        Log.d(TAG, "parseJSON: " + parrent);
        JSONObject menu = parrent.getJSONObject("menu");
        Log.d(TAG, "parseJSON: "+ menu);
        JSONArray Items = menu.getJSONArray("items");
        Log.d(TAG, "parseJSON: "+ Items.get(1).toString());
        JSONObject label1 = (JSONObject) Items.get(1);
        Log.d(TAG, "parseJSON: " + label1);
        JSONObject label7 = (JSONObject) Items.get(7);
        Log.d(TAG, "parseJSON: " + label7);



        sum = label1.getInt("id") + label7.getInt("id");
        Toast.makeText(this, "" + sum, Toast.LENGTH_SHORT).show();


    }
}
