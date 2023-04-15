package com.example.fintechlab51pd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView tvContent;

    private ListView Rates;
    private ArrayAdapter ListAdapter;
    private ArrayList<String> CurrencyRateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading live data from ECB...");
        new DataLoader(){
            @Override
            public void onPostExecute(List<String> result)
            {
                tvContent.setText("Currency ratios");
                Rates = findViewById(R.id.Rates);
                CurrencyRateList = new ArrayList<String>(result);
                ListAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, CurrencyRateList);
                Rates.setAdapter(ListAdapter);
            }
        }.execute();
    }
}