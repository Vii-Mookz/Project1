package com.example.vipavee.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vipavee on 24/07/2017.
 */

public class MainAdapter extends BaseAdapter{
    private Context context;
    private int[] intsPic;
    private String[] name;
    private String[] detail;

    public MainAdapter(Context context, int[] intsPic, String[] name, String[] detail) {
        this.context = context;
        this.intsPic = intsPic;
        this.name = name;
        this.detail = detail;
    }

    @Override
    public int getCount() {
        return intsPic.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_layout, parent, false);
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView txtname = (TextView) view1.findViewById(R.id.txtHead);
        TextView txtdetail = (TextView) view1.findViewById(R.id.txtDetail);

        imageView.setImageResource(intsPic[position]);
        txtname.setText(name[position]);
        txtdetail.setText(detail[position]);


        return view1;
    }
}
