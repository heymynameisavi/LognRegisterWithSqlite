package com.example.android.loginandregister;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;

    public User(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {   
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
