package com.graffiti75.android.gojimo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.adapter.QualificationsAdapter;
import com.graffiti75.android.gojimo.model.Qualifications;
import com.graffiti75.android.gojimo.model.Subject;
import com.graffiti75.android.gojimo.service.RetrofitService;

import java.lang.reflect.Type;
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
    public static final String SUBJECT_EXTRA = "subject_extra";
    public static final String GOJIMO_DATA = "gojimo_data";

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private RetrofitService mService;
    private List<Qualifications> mQualificationsList;
    private MaterialDialog mMaterialDialog;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gets the layout.
        setLayout();

        // Gets data.
        getData();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void setLayout() {
        // Progress Bar.
        mMaterialDialog = new MaterialDialog.Builder(this).title(R.string.progress_dialog)
            .content(R.string.please_wait).progress(true, 0).show();

        // Toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                menuClicked();
                return true;
            }
        });
    }

    public void getData() {
        // Checks the data.
        String converted = getPreference(GOJIMO_DATA);
        if (converted == null || converted.length() <= 0) {
            // Get from Backend.
            getGojimoDataFromBackend();
        } else {
            // Get from Cache.
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Qualifications>>(){}.getType();
            mQualificationsList = (List<Qualifications>) gson.fromJson(converted, listType);
            setQualificationsRecyclerView();
        }
    }

    public void getGojimoDataFromBackend() {
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
                dataDownloadedSuccessfully(object);
            }
        });
    }

    public void setQualificationsRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_qualifications_recycler_view);
        recyclerView.setVisibility(RecyclerView.VISIBLE);
        mMaterialDialog.cancel();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        QualificationsAdapter qualificationsAdapter = new QualificationsAdapter(this, mQualificationsList);
        qualificationsAdapter.SetOnClickListener(new QualificationsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                onQualificationClicked(position);
            }
        });
        recyclerView.setAdapter(qualificationsAdapter);
    }

    //--------------------------------------------------
    // Listener Methods
    //--------------------------------------------------

    public void menuClicked() {
        // Dialog.
        mMaterialDialog = new MaterialDialog.Builder(MainActivity.this)
            .title(R.string.progress_dialog).content(R.string.please_wait).progress(true, 0)
            .show();

        // Gets the data.
        getGojimoDataFromBackend();
    }

    public void dataDownloadedSuccessfully(List<Qualifications> object) {
        // Updates the attribute.
        mQualificationsList = object;

        // Sets the Preference.
        Gson gson = new Gson();
        String converted = gson.toJson(object);
        setPreference(GOJIMO_DATA, converted);

        // Sets the Recycler View.
        setQualificationsRecyclerView();
    }

    public void onQualificationClicked(Integer position) {
        // Gets the extra.
        Qualifications item = mQualificationsList.get(position);
        List<Subject> list = item.getSubjects();
        if (list == null || list.size() <= 0) {
            Crouton.makeText(MainActivity.this, getString(R.string.activity_subject_list_empty), Style.ALERT).show();
        } else {
            Gson gson = new Gson();
            String converted = gson.toJson(item);

            // Calls Subject Activity.
            Intent intent = new Intent(MainActivity.this, SubjectActivity.class);
            intent.putExtra(SUBJECT_EXTRA, converted);
            startActivity(intent);
        }
    }

    //--------------------------------------------------
    // Preferences
    //--------------------------------------------------

    public void setPreference(String key, String data) {
        // Gets the preference.
        SharedPreferences pref = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // Saves the preference.
        editor.putString(key, data);
        editor.commit();
    }

    public String getPreference(String key) {
        SharedPreferences pref = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        String data = pref.getString(key, "");
        return data;
    }
}