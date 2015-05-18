package com.graffiti75.android.gojimo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.adapter.QualificationsAdapter;
import com.graffiti75.android.gojimo.adapter.SubjectAdapter;
import com.graffiti75.android.gojimo.model.Qualifications;
import com.graffiti75.android.gojimo.model.Subject;
import com.graffiti75.android.gojimo.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Rodrigo Cericatto on 18/05/2015.
 */
public class SubjectActivity extends Activity {

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setSubjectRecyclerView();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void setSubjectRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_subject_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String converted = getIntent().getExtras().getString(MainActivity.SUBJECT_EXTRA);
        Gson gson = new Gson();
        Qualifications qualifications = gson.fromJson(converted, Qualifications.class);
        SubjectAdapter subjectAdapter = new SubjectAdapter(this, qualifications.getSubjects());
        recyclerView.setAdapter(subjectAdapter);
    }
}