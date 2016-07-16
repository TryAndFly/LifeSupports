package com.example.lifesupport.AlarmClock;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/15.
 */

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Clock> arrayList = new ArrayList();
    private   Clock clock;
    private int hour,minute,id;
    private boolean isUse;
    private ClockSQLite clockSQLite;
    private SQLiteDatabase sqLiteDatabase;

    public static Context context;

    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    new AlertDialog.Builder(MainActivity.context).setTitle("闹钟").setMessage("傻逼该起床了").setPositiveButton("关闭闹钟", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mediaPlayer.stop();
                        }
                    }).show();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);

        Intent intent = new Intent(this,LongRunningService.class);
        startService(intent);

        clockSQLite = new ClockSQLite(this);
        sqLiteDatabase=clockSQLite.getWritableDatabase();
        context=this;
        listView = (ListView)findViewById(R.id.listView);
        init();
    }
    //初始化数据
    public void init(){
        arrayList.clear();
        Cursor cursor = sqLiteDatabase.query("db_clock",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            id=Integer.parseInt(cursor.getString(0));
            hour=Integer.parseInt(cursor.getString(1));
            minute=Integer.parseInt(cursor.getString(2));
            isUse=Boolean.parseBoolean(cursor.getString(4));//此处second用做tag符号
            clock = new Clock(hour,minute,id,isUse);
            Log.d("test","添加的数据为"+hour+""+minute);
            arrayList.add(clock);
        }
        cursor.close();
        ClockAdapter clockAdapter = new ClockAdapter(this,arrayList);
        listView.setAdapter(clockAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //点击创建菜单的任务
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this,"创建一个闹钟",Toast.LENGTH_SHORT).show();
        //开启下一个页面
        Intent intent = new Intent(this,SetClockActivity.class);
        startActivityForResult(intent,1);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == 1){
                    clock = (Clock) data.getSerializableExtra("data");
                    Log.d("test","接受数据"+clock.getHour()+""+clock.getMinute()+"");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("hour",clock.getHour());
                    contentValues.put("minute",clock.getMinute());
                    contentValues.put("second",clock.getSecond());
                    contentValues.put("isUse",clock.isUse());
                    sqLiteDatabase.insert("db_clock",null,contentValues);
                    init();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void set(View view){
        Integer id =(Integer) view.getTag();
        //更改属性
//        Toast.makeText(this,"改变"+id+"",Toast.LENGTH_LONG).show();
//        Cursor cursor = sqLiteDatabase.query("db_clock",null,null,null,null,null,null);
//        cursor.moveToNext();
//        isUse=Boolean.parseBoolean(cursor.getString(4));
//        if (isUse){
//            isUse=false;
//        }else {
//            isUse=true;
//        }
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("isUse",isUse);
//        sqLiteDatabase.update("db_clock",contentValues,"id = ?",new String[]{ id+""});
//        cursor.close();
//        init();
    }
}
