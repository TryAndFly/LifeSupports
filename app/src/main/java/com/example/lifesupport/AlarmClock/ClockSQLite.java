package com.example.lifesupport.AlarmClock;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/15.
 */
public class ClockSQLite extends SQLiteOpenHelper {

    public static final String CREATE_CLOCK ="create table db_clock(" +
            "id integer primary key autoincrement," +
            "hour integer," +
            "minute integer," +
            "second integer," +
            "isUse boolean)";

    public ClockSQLite(Context context) {
        super(context,"clock.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CLOCK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
