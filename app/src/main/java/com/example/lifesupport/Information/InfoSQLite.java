package com.example.lifesupport.Information;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/14.
 */
public class InfoSQLite extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "create table tb_information(" +
            "id integer primary key autoincrement," +
            "imageId integer," +
            "title String," +
            "text String," +
            "type integer)";
    public InfoSQLite(Context context) {
        super(context, "heep.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("test","创建表格成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
