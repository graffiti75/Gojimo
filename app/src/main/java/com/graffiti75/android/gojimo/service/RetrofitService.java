package com.graffiti75.android.gojimo.service;

import com.graffiti75.android.gojimo.model.Qualifications;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public interface RetrofitService {
    @GET("/api/v4/qualifications")
    void listQualifications(Callback<List<Qualifications>> callback);
}