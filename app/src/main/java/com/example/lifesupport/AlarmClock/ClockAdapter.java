package com.example.lifesupport.AlarmClock;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextClock;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/15.
 */
public class ClockAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Clock> arrayList;
    private TextClock textClock;
    private Switch aSwitch;
    private int Minute,Hour;
    private boolean IsUse;

    public ClockAdapter(Context context, ArrayList<Clock> arrayList) {
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

        view = View.inflate(context, R.layout.item_setclock_layout,null);
        textClock = (TextClock)view.findViewById(R.id.textClock);
        aSwitch = (Switch)view.findViewById(R.id.switch1);
        Clock clock = arrayList.get(i);
        Hour=clock.getHour();
        Minute = clock.getMinute();
        IsUse = clock.isUse();
        Log.d("test","准备输出的数据是:"+Hour+""+Minute);
//        textClock.setFormat12Hour(Hour+":"+Minute+"");
        textClock.setFormat24Hour(Hour+":"+Minute+"");
        aSwitch.setChecked(!IsUse);
        //getSecond为之前设置的标识符
        aSwitch.setTag(clock.getSecond());
        return view;
    }
}

