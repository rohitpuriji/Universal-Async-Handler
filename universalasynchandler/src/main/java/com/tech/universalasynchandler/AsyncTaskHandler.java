package com.tech.universalasynchandler;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by rohitpuri on 26/7/17.
 */

public class AsyncTaskHandler {
    private static final String TAG = "AllHttpRequests";

    private static final int STATUS_FOUND = 200;


    public static Object callHttpPostRequestsV2(String url, JSONObject obj) {
        HttpURLConnection connection = null;
        url = url.replaceAll(" ", "%20");
        AppLogs.printLogs("json req for url:", " is :: " + url + " ::" + obj.toString());

        try {
            if (connection != null) {
                connection.disconnect();
            }
            HttpURLConnection.setFollowRedirects(false);
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Length", "" + obj.toString().getBytes().length);
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(obj.toString());
            wr.flush();
            wr.close();

            connection.setConnectTimeout(300000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            AppLogs.printLogs(TAG, "Response code: " + connection.getResponseCode() + ", Message: " + connection.getResponseMessage());

            if (responseCode == STATUS_FOUND) {
                AppLogs.printLogs(TAG, "Success....");

                String response = new String(FileUtil.toByteArray(connection.getInputStream()));
                AppLogs.printLogs(TAG, "Response : " + response);
                AppLogs.printLogs("json res from url:", " is :: " + url + " ::" + response);

                return response;
            } else {
                return new Exception();
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return e;
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
            return e;
        } catch (Exception e) {
            return e;
        }
    }
}