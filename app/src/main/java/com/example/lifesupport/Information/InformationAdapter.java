package com.example.lifesupport.Information;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/14.
 */
public class InformationAdapter extends BaseAdapter {

    private ArrayList<Information> arrayList;
    private Context context;

    private ImageView imageView;
    private TextView textView;
    private Information information;

    public InformationAdapter(Context context, ArrayList<Information> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.information_item_layout,null);
        imageView = (ImageView)view.findViewById(R.id.imageView);
        textView = (TextView)view.findViewById(R.id.text);

        information = arrayList.get(i);
        imageView.setImageResource(information.getImage_id());
        textView.setText(information.getTitle());

        return view;
    }
}
