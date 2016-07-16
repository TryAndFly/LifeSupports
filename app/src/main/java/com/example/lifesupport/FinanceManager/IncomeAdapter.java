package com.example.lifesupport.FinanceManager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/14.
 */
public class IncomeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Count> arrayList;

    private TextView textView_name,textView_money;
    private Count count;
    public IncomeAdapter(Context context, ArrayList<Count> arrayList) {
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
        view = View.inflate(context, R.layout.income_item_layout,null);
        textView_name = (TextView) view.findViewById(R.id.item_name);
        textView_money =(TextView)view.findViewById(R.id.item_money);
        count = arrayList.get(i);
        textView_name.setText(count.getName());
        textView_money.setText(count.getMoney()+"");
        return view;
    }
}
