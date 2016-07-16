package com.example.lifesupport.AlarmClock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import com.example.lifesupport.R;

/**
 * Created by Administrator on 2016/7/15.
 */
public class SetClockActivity extends Activity {
    private TimePicker timePicker;
    private static int hour=15,minute=30;
    public static Clock clock=new Clock(hour,minute,0,true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setclocklayout);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        //添加默认时间
        timePicker.setCurrentHour(15);
        timePicker.setCurrentMinute(30);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour=timePicker.getCurrentHour();
                minute=timePicker.getCurrentMinute();
//                Log.d("test",hour+":"+minute);
                clock = new Clock(hour,minute,0,true);
                Log.d("test","数据"+hour+":"+minute+"");
            }
        });
    }

    public void ok(View view){
//        Log.d("test","准备获取数据");
        hour=timePicker.getCurrentHour();
        minute=timePicker.getCurrentMinute();
        Log.d("test",hour+":"+minute);
        clock = new Clock(hour,minute,0,true);
        Log.d("test","数据"+hour+":"+minute+"");
        Intent intent = new Intent();
        intent.putExtra("data",clock);
        setResult(1,intent);
        finish();
    }
    public void cancel(View view){
        finish();
    }
}
