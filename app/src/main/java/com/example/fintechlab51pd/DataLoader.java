package com.example.fintechlab51pd;

import android.os.AsyncTask;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class DataLoader extends AsyncTask<String, Void, List<String>> {

    protected List<String> doInBackground(String... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            List<String> list = new ArrayList<>(List.of(sw.toString()));
            return list;
        }
    }
}
