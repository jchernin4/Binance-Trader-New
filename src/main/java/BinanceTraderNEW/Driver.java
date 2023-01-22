package BinanceTraderNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Driver {

    public static void main(String[] args) throws IOException {
        String queryString = "&symbol=" + Settings.symbol + "&interval=" + Settings.interval + "&limit=3";
        URL url = new URL("https://api.binance.us/api/v3/klines?" + queryString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        con.connect();
        int respCode = con.getResponseCode();

        String[][] arr = { { "" } };
        if (respCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            arr = new Gson().fromJson(response.toString(), String[][].class);
        }

        ArrayList<Kline> klineArr = new ArrayList<>();
        if (!arr[0][0].equals("")) {
            for (int i = 0; i < arr.length; i++) {
                String[] kline = arr[i];
                klineArr.add(new Kline(kline[0], kline[1], kline[2], kline[3], kline[4], kline[5], kline[6], kline[7], kline[8], kline[9], kline[10]));
            }
        }

        for (Kline k : klineArr) {
            System.out.println("Close price: " + k.closePrice);
        }

        con.disconnect();
    }
}
