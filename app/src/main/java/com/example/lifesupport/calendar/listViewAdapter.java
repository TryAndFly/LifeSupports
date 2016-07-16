package com.example.lifesupport.calendar;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lifesupport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class listViewAdapter extends BaseAdapter {
    private List<Time> listViewList;
    private Context context;
    private gridViewAdapter adapter;
    public static boolean tagYearMonth;//此变量用于判断现在是否是指定的月份
    //创建一个集合存放元素GridView
    private List<String> gridViewList = new ArrayList();
    private ReGridView gridView;
    public listViewAdapter(Context context, List<Time> listViewList) {
        this.context = context;
        this.listViewList = listViewList;
    }

    @Override
    public int getCount() {
        return listViewList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolders holders;
        View v;
        if (view == null) {
            holders = new ViewHolders();
            v = View.inflate(context, R.layout.calendar_item_layout, null);
            gridView = new ReGridView(context);
            //gridView
            holders.gridView = (ReGridView) v.findViewById(R.id.grid_view);
            holders.textView = (TextView)v.findViewById(R.id.month);
            v.setTag(holders);

        }else {
            v = view;
            holders = (ViewHolders)v.getTag();
        }
        Log.d("test","准备数据");
        //设置文本
        holders.textView.setText(listViewList.get(i).getYear()+"年"+listViewList.get(i).getMonth()+"月");
        //清除数据
        clear();
        //初始化
        initGridViewList(listViewList.get(i).getYear(), listViewList.get(i).getMonth());
        //gridView适配器
        adapter = new gridViewAdapter(context, gridViewList);
        holders.gridView.setAdapter(adapter);
        return v;
    }

    class ViewHolders{
        ReGridView gridView;
        TextView textView;
    }
    //根据传入年月份进行初始化GridViewList
    public void initGridViewList(int year,int month){
        String a[]=new String[42];
        Calendar date=Calendar.getInstance();
        date.set(year,month-1,1);
        int week=date.get(Calendar.DAY_OF_WEEK)-1;
        int day=0;
        //大月
        if(month==1||month==3||month==5||month==7 ||month==8||month==10||month==12) {
            day=31;
        }
        //小月
        if(month==4||month==6||month==9||month==11){
            day=30;
        }
        //判断平年与闰年
        if(month==2){
            if(((year%4==0)&&(year%100!=0))||(year%400==0)){
                day=29;
            }else {
                day=28;
            }
        }
        //前面的天数,置为0的为空
        for (int i=0;i<week;i++){
            a[i] = String.valueOf(0);
            gridViewList.add(a[i]);
        }
        for(int i=week,n=1;i<week+day;i++)
        {
            //System.out.println(n);
            a[i]=String.valueOf(n) ;
            n++;
            gridViewList.add(a[i]);
        }
        for (int i =week+day;i<42;i++){
            a[i] =String.valueOf(0);
            gridViewList.add(a[i]);
        }
    }
    public void clear(){
        gridViewList.clear();
    }
}
