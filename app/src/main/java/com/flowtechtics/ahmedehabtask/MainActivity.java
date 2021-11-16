package com.flowtechtics.ahmedehabtask;

import static com.flowtechtics.ahmedehabtask.utilities.ImageHelper.getBitmapFromURL;

import static org.testng.AssertJUnit.assertEquals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.ehab.networkFramework.JSONObjectRequestListener;
import com.ehab.networkFramework.NetworkConnect;
import com.flowtechtics.ahmedehabtask.databinding.ActivityMainBinding;
import com.flowtechtics.ahmedehabtask.models.DataModel;
import com.flowtechtics.ahmedehabtask.presenter.HomePresenter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements DataListener{
    private static final String JSON_URL = "https://api.github.com/users/brynary";
    private ActivityMainBinding binding ;
    HomePresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();

    }

    private void init(){
        presenter = new HomePresenter(this);
        presenter.getDataFromUrl(JSON_URL , "GET");

    }

    @Override
    public void getDate(DataModel dataModel) {
        setUserData(dataModel);
    }

    private void setUserData(DataModel model){
        binding.profilePic.setClipToOutline(true);
        binding.name.setText(model.getName());
        binding.companyName.setText(model.getCompany());
        binding.bio.setText(model.getBio());
        binding.type.setText(model.getType());

    }

}