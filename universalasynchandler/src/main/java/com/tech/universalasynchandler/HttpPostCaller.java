package com.tech.universalasynchandler;

import android.app.Activity;

import org.json.JSONObject;

/**
 * Created by rohitpuri on 27/7/17.
 */

public class HttpPostCaller {

    public Object getResponse(Activity aActivity, final String aHttpUrl, final JSONObject aRequestJsonObject, String aLoadingMsg){

        new BackgroundTask(aActivity, new BackgroundThread() {
            @Override
            public Object runTask() {
                return AsyncTaskHandler.callHttpPostRequestsV2(aHttpUrl, aRequestJsonObject);
            }

            @Override
            public Object taskCompleted(Object data) {
                return data;
            }
        },aLoadingMsg).execute();

        return null;
    }

}
