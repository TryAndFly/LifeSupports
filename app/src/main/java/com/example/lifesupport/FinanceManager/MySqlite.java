package com.example.lifesupport.FinanceManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MySqlite extends SQLiteOpenHelper {
    private static final String CREATE_COU="create table cou(" +
            "id integer primary key autoincrement," +
            "type integer," +
            "name String," +
            "money double)";
    public MySqlite(Context context) {
        super(context, "count.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COU);
        Log.d("test","创建表格成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
