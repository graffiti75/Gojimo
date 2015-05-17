package com.graffiti75.android.gojimo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.model.Qualifications;
import com.graffiti75.android.gojimo.service.RetrofitService;

import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class MainActivity extends Activity {

    //--------------------------------------------------
    // Constants
    //--------------------------------------------------

    public static final String END_POINT = "https://api.gojimo.net";

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private RetrofitService mService;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getGojimoData();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void getGojimoData() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(END_POINT).build();
        mService = restAdapter.create(RetrofitService.class);
        mService.listQualifications(new Callback<List<Qualifications>>() {
            @Override
            public void failure(RetrofitError retrofitError) {
                String cause = retrofitError.getCause().getMessage();
                String text = getString(R.string.error_cause) + cause + ".";
                Crouton.makeText(MainActivity.this, text, Style.ALERT).show();
            }

            @Override
            public void success(List<Qualifications> object, Response response) {
                //
            }
        });
    }
}