package com.graffiti75.android.gojimo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;
import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.adapter.SubjectAdapter;
import com.graffiti75.android.gojimo.model.Qualifications;

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

        setLayout();
        setSubjectRecyclerView();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void setLayout() {
        // Toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle(getString(R.string.activity_subject));
        toolbar.setNavigationIcon(R.drawable.ic_home_as_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

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