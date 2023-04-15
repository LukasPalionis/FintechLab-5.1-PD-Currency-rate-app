package com.example.fintechlab51pd;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static List<String> getRateFromECB() throws IOException {
        List<String> CurrRateList = new ArrayList<>(List.of("Failed to get data" ));
        InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            CurrRateList = XmlParser.getRateFromECB(stream);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return CurrRateList;
    }

    private static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
