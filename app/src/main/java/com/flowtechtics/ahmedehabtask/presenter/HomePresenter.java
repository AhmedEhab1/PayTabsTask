package com.flowtechtics.ahmedehabtask.presenter;

import android.util.Log;

import com.ehab.networkFramework.JSONObjectRequestListener;
import com.ehab.networkFramework.NetworkConnect;
import com.flowtechtics.ahmedehabtask.DataListener;
import com.flowtechtics.ahmedehabtask.models.DataModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class HomePresenter {
    DataListener listener;

    public HomePresenter(DataListener dataListener) {
        this.listener = dataListener;
    }

    private void requestData(String JSON_URL, String requestMethod) {
        new NetworkConnect(JSON_URL, requestMethod).setCustomEventListener(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                getDataModel(response);
            }

            @Override
            public void onError(IOException error) {

            }
        });
    }

    public void getDataFromUrl(String JSON_URL, String requestMethod) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    requestData(JSON_URL, requestMethod);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void getDataModel(JSONObject response) {
        try {
            DataModel dataModel = DataModel.fromJson(response);
            listener.getDate(dataModel);

        } catch (Exception e) {
            // e.printStackTrace();
            Log.d("error", "getDataModel: " + e);
        }
    }
}
