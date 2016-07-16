package com.example.lifesupport.AlarmClock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 重新开启一个服务，使得多次运行
        Intent intent1 = new Intent(context,LongRunningService.class);
        context.startService(intent1);
        //Log.d("test","开启服务");
    }
}
