package com.example.trabalhoandroidloginmvc;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by thaisandrade-luizalabs on 01/06/15.
 */
public class FiapRequestManager {

    private Context context;

    public FiapRequestManager(Context context){
        this.context = context;
    }

    public void requestContent(String url, Response.Listener<String> onSuccess, Response.ErrorListener onError) {
        StringRequest catRequest = new StringRequest(Request.Method.GET, url, onSuccess, onError);
        MyVolley.getRequestQueue().add(catRequest);
    }
}
