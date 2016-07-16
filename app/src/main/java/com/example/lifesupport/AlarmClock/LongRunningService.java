package com.example.lifesupport.AlarmClock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/7/15.
 */
public class LongRunningService extends Service {
    private ClockSQLite clockSQLite ;
    private SQLiteDatabase sqLiteDatabase ;
    private Cursor cursor;
    private int hour,minute,Hour,Minute;
    private Boolean isUse;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        在onStartCommand中开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                clockSQLite = new ClockSQLite(LongRunningService.this);
                sqLiteDatabase = clockSQLite.getReadableDatabase();
                Calendar calendar = Calendar.getInstance();
                //当前时间
                Hour=calendar.get(Calendar.HOUR);
                Minute =calendar.get(Calendar.MINUTE);
                Log.d("test",Hour+":"+Minute);
                Log.d("test","准备查询数据库"+Hour+":"+Minute);
                cursor = sqLiteDatabase.query("db_clock",null,null,null,null,null,null);
                while (cursor.moveToNext()){
                    hour=Integer.parseInt(cursor.getString(1));
                    minute=Integer.parseInt(cursor.getString(2));
                    isUse=Boolean.parseBoolean(cursor.getString(4));
                    Log.d("test","查询中"+hour+":"+minute);
                    if (!isUse){//如果闹钟开启且时间到了
                        if (Hour == hour && Minute == minute){
                            Log.d("test","开启闹钟了");
                            Message message = new Message();
                            message.what = 1;
                            MainActivity.handler.sendMessage(message);
                        }
                    }
                }
                cursor.close();
            }
        }).start();
        //获取AlarmManager实例
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        //设置一个定时任务
        int minute = 60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + minute;//获取开机到现在的毫秒数加上要定时的时间
        Intent intent1 = new Intent(this,AlarmReceiver.class);

        //指定处理任务的意图
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent1,0);
        //设置定时
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);
        }
//        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,System.currentTimeMillis(),10*1000,pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

}
