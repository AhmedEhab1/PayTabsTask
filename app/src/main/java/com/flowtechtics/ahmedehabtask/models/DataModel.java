package com.flowtechtics.ahmedehabtask.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DataModel {

    public static DataModel fromJson(JSONObject jsonObject) {
        DataModel model = new DataModel();
        // Deserialize json into object fields
        try {
            model.name = jsonObject.getString("name");
            model.id = jsonObject.getInt("id");
            model.type = jsonObject.getString("type");
            model.avatar_url = jsonObject.getString("avatar_url");
            model.company = jsonObject.getString("company");
            model.bio = jsonObject.getString("bio");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return model;
    }

    private String name;
    private String company;
    private String bio;
    private String avatar_url;
    private int id;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
