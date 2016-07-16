package com.example.lifesupport.calendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lifesupport.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/14.
 */

public class gridViewAdapter extends BaseAdapter {

    private List<String> arr;
    private Context context;
    private String string;

    private TextView textView;
    public gridViewAdapter(Context context, List<String> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.calendar_day_layout,null);
        textView = (TextView)view.findViewById(R.id.day);
        //获取数据
        string = arr.get(i);
        if ("0".equals(string)){
            //如果为零的则不输出
            textView.setText(" ");
        }else {
            textView.setText(string);
        }
        return view;
    }
}
