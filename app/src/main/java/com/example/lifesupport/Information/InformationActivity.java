package com.example.lifesupport.Information;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lifesupport.R;

/**
 * Created by Administrator on 2016/7/14.
 */
public class InformationActivity extends Activity {
    private InfoSQLite infoSQLite;
    private SQLiteDatabase sqLiteDatabase;
    private TextView textView_title;
    private TextView textView_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        textView_text = (TextView)findViewById(R.id.content) ;
        textView_title = (TextView)findViewById(R.id.titles);

        infoSQLite =  new InfoSQLite(this);
        sqLiteDatabase = infoSQLite.getReadableDatabase();

        Intent intent =getIntent();
        String id = intent.getStringExtra("extra_data");
        //根据传入的数据进行检索
        Cursor cursor = sqLiteDatabase.query("tb_information",null,"id = ?",new String[]{id},null,null,null);
        cursor.moveToNext();
        //获取这条数据
        String title =cursor.getString(2);
        String text =cursor.getString(3);
        textView_title.setText(title);
        textView_text.setText(text);
        //Toast.makeText(InformationActivity.this,id,Toast.LENGTH_SHORT).show();
    }
}
