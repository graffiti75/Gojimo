package com.graffiti75.android.gojimo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.adapter.QualificationsAdapter;
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

    private MaterialDialog mMaterialDialog;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
        getGojimoData();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void setLayout() {
        // Progress Bar.
        mMaterialDialog = new MaterialDialog.Builder(this).title(R.string.progress_dialog).content(R.string.please_wait).progress(true, 0).show();
    }

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
                setQualificationsRecyclerView(object);
            }
        });
    }

    public void setQualificationsRecyclerView(List<Qualifications> object) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_qualifications_recycler_view);
        recyclerView.setVisibility(RecyclerView.VISIBLE);
        mMaterialDialog.cancel();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        QualificationsAdapter qualificationsAdapter = new QualificationsAdapter(this, object);
        qualificationsAdapter.SetOnClickListener(new QualificationsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Crouton.makeText(MainActivity.this, "Position is " + position + "." , Style.CONFIRM).show();
            }
        });
        recyclerView.setAdapter(qualificationsAdapter);
    }
}