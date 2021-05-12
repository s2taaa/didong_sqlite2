package com.example.sqlite2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context ctx;
    int layoutItem;
    ArrayList<Place> arrayList;

    public CustomAdapter(Context ctx, int layoutItem, ArrayList<Place> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Place place = (Place) getItem(position);

        view = LayoutInflater.from(ctx).
                inflate(layoutItem,parent,false);

        TextView tvName = view.findViewById(R.id.tvName);

        tvName.setText(arrayList.get(position).getName());


        return view;
    }
}
