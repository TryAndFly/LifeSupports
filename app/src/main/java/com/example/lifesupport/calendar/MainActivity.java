package com.example.lifesupport.calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifesupport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainActivity extends AppCompatActivity {


    //创建一个集合存放元素ListView
    private List<Time> listViewList = new ArrayList();
    private ListView listView;
    private Button button;
    private EditText editText;
    private TextView textView;
    private static int month,year,day;
    private static final int UPDATE = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE:
                    String years = editText.getText().toString().substring(0, 4);
                    year = Integer.parseInt(years);
                    String months = editText.getText().toString().substring(5, 7);
                    month = Integer.parseInt(months);
                    //Log.d("test", year + "|" + month);
                    //
                    button = (Button)findViewById(R.id.search_text);
                    editText = (EditText)findViewById(R.id.text_time);

                    //listView适配器
                    listView =(ListView)findViewById(R.id.monthListView);
                    //清除原有数据
                    listViewList.clear();
                    //刷新UI
                    initListViewList();
                    listViewAdapter adapter1 = new listViewAdapter(MainActivity.this,listViewList);
                    listView.setAdapter(adapter1);
                    //设置滚动到指定月份
                    listView.setSelection(month-1);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test_calendar","准备数据");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calendar_layout);
        Log.d("test_calendar","准备数据");
        button = (Button)findViewById(R.id.search_text);
        editText = (EditText)findViewById(R.id.text_time);

        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month =calendar.get(Calendar.MONTH);
        day =calendar.get(Calendar.DAY_OF_MONTH);

        //listView适配器
        listView =(ListView)findViewById(R.id.monthListView);
        initListViewList();
        Log.d("test_calendar","准备按钮事件");
        listViewAdapter adapter1 = new listViewAdapter(com.example.lifesupport.calendar.MainActivity.this,listViewList);
        listView.setAdapter(adapter1);
        Log.d("test_calendar","按钮事件");
        //设置滚动到指定月份
        listView.setSelection(month);

        //设置按钮事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("test",editText.getText().toString());
                //检测数据是否符号要求
                boolean b=isViable(editText.getText().toString());
                //Log.d("test",String.valueOf(b));
                if(b){
                    Toast.makeText(MainActivity.this,"正在查询",Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message message = new Message();
                            message.what = UPDATE;
                            handler.sendMessage(message);
                        }
                    }).start();
                }else {
                    Toast.makeText(MainActivity.this,"输入的数据不符合要求",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //检测数据是否符号要求
    public  boolean isViable(String string){
        if (string.length() == 10){
            if ("-".equals(string.charAt(4)+"") &&"-".equals(string.charAt(7)+"")){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    //初始化listViewList
    public void initListViewList(){
        Time time ;
        //加载当前年份的所有月
        for (int i = 1; i <= 12; i++) {
            time = new Time(year,i);
            listViewList.add(time);
        }
    }
}
