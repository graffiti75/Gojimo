package com.graffiti75.android.gojimo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.model.Qualifications;

import java.util.List;

/**
 * Created by Rodrigo Cericatto on 13/05/2015.
 */
public class QualificationsAdapter extends RecyclerView.Adapter<QualificationsAdapter.ViewHolder> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private List<Qualifications> mItems;
    private Activity mContext;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public QualificationsAdapter(Activity context, List<Qualifications> items) {
        mContext = context;
        mItems = items;
    }

    //--------------------------------------------------
    // Adapter Methods
    //--------------------------------------------------

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_qualifications, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Qualifications item = mItems.get(position);

        // Id.
        String text = mContext.getString(R.string.adapter_qualifications_id);
        holder.id.setText(text + " " + item.getId());

        // Name.
        text = mContext.getString(R.string.adapter_qualifications_name);
        holder.name.setText(text + " " + item.getName());

        // Country.
        text = mContext.getString(R.string.adapter_qualifications_country);
        if (item.getCountry() == null) {
            holder.country.setText(text);
        } else {
            holder.country.setText(text + " " + item.getCountry().getCode());
        }

        // Subjects.
        text = mContext.getString(R.string.adapter_qualifications_subjects);
        if (item.getSubjects() == null) {
            holder.subjects.setText(text);
        }

        // Link.
        text = mContext.getString(R.string.adapter_qualifications_link);
        if (item.getLink() == null) {
            holder.link.setText(text);
        } else {
            holder.link.setText(text + " " + item.getLink());
        }

        // Default Products.
        text = mContext.getString(R.string.adapter_qualifications_default_products);
        if (item.getDefaultProducts() == null) {
            holder.defaultProducts.setText(text);
        }
    }

    @Override
    public int getItemCount() {
        if (mItems != null && mItems.size() > 0) {
            return mItems.size();
        }
        return 0;
    }

    //--------------------------------------------------
    // View Holder
    //--------------------------------------------------

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView name;
        public TextView country;
        public TextView subjects;
        public TextView link;
        public TextView defaultProducts;

        public ViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id_qualifications_id_text_view);
            name = (TextView) view.findViewById(R.id.id_qualifications_name_text_view);
            country = (TextView) view.findViewById(R.id.id_qualifications_country_text_view);
            subjects = (TextView) view.findViewById(R.id.id_qualifications_subjects_text_view);
            link = (TextView) view.findViewById(R.id.id_qualifications_link_text_view);
            defaultProducts = (TextView) view.findViewById(R.id.id_qualifications_default_products_text_view);
        }
    }
}