package com.android.tonyvu.sc.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recommend extends AppCompatActivity {

    TextView PrintRecommendations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        //String book = "1635  The Eastern Front";

        PrintRecommendations = (TextView) findViewById(R.id.recommended);

        String book = "1635  The Eastern Front";
        JSONObject obj = null;

        try {
            obj = new JSONObject(loadJSONFromAsset());
            String rec = obj.getString(book), mystring="";
            ArrayList<String> booklist = new ArrayList<> (Arrays.asList(rec.split("\\s*,\\s*")));
            for(String i:booklist){
                mystring = mystring + i + "\n";
            }
            Intent intent = new Intent(Recommend.this, HorizontalListView.class);
            intent.putStringArrayListExtra("key", booklist);
            startActivity(intent);
            //PrintRecommendations.setText(mystring);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //JSONArray m_jArry = obj.getJSONArray("formules");

        /*for (String book : bookList){
            String rec = (String) DataSnapshot.child (book).getValue(), new;
            while (!(rec.equals("") || rec.equals(" "))){
                new = new + rec.substring(0, rec.indexOf(',')).trim() + "\n";
                rec = rec.substring(rec.indexOf(',')+1).trim();
            }*/
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("recommendations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
