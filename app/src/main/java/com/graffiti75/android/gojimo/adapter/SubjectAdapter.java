package com.graffiti75.android.gojimo.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graffiti75.android.gojimo.R;
import com.graffiti75.android.gojimo.model.Subject;

import java.util.List;

/**
 * Created by Rodrigo Cericatto on 18/05/2015.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private List<Subject> mItems;
    private Activity mContext;
    OnItemClickListener mItemClickListener;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public SubjectAdapter(Activity context, List<Subject> items) {
        mContext = context;
        mItems = items;
    }

    //--------------------------------------------------
    // Adapter Methods
    //--------------------------------------------------

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Subject item = mItems.get(position);

        // Layout.
        String color = item.getColour();
        holder.layout.setBackgroundColor(Color.parseColor(color));

        // Id.
        String text = mContext.getString(R.string.adapter_subject_id);
        holder.id.setText(text + " " + item.getId());

        // Name.
        text = mContext.getString(R.string.adapter_subject_title);
        holder.title.setText(text + " " + item.getTitle());

        // Link.
        text = mContext.getString(R.string.adapter_subject_link);
        holder.link.setText(text + " " + item.getLink());
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout layout;
        public TextView id;
        public TextView title;
        public TextView link;

        public ViewHolder(View view) {
            super(view);
            layout = (LinearLayout) view.findViewById(R.id.id_subject_linear_layout);
            id = (TextView) view.findViewById(R.id.id_subject_id_text_view);
            title = (TextView) view.findViewById(R.id.id_subject_title_text_view);
            link = (TextView) view.findViewById(R.id.id_subject_link_text_view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Integer position = getPosition();
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, position);
            }
        }
    }

    //--------------------------------------------------
    // Listener
    //--------------------------------------------------

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}