package com.example.lifesupport.FinanceManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifesupport.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/14.
 */

public class MainActivity extends AppCompatActivity {

    static double totalIncome,totalPay,after;

    private TextView textViewIncome,textViewPay,textViewafter;
    private ListView listView;
    private ArrayList<Count> arrayList = new ArrayList();
    private Button see_list;

    private String name;
    private Double money;
    private int type;
    private int id;
    private Count count;

    private MySqlite sqlites;
    private IncomeAdapter incomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_layout);
//        fab.setRippleColor(666);
        //设置按下去的波纹颜色
//        fab.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_menu_add));
        sqlites =new MySqlite(this);
        //获取listView控件
        listView = (ListView)findViewById(R.id.income);
        textViewIncome = (TextView)findViewById(R.id.totalIncome);
        textViewPay = (TextView)findViewById(R.id.totalPay);
        textViewafter = (TextView)findViewById(R.id.after);
        see_list = (Button)findViewById(R.id.see_list);
        initArrayList();

        //添加长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                count = arrayList.get(i);
                // 创建一个列表对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //设置标题
                builder.setTitle("请选择");
                //列表字段
                final String[] items = { "删除" };
                //设置列表对话框
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, items[i],Toast.LENGTH_SHORT).show();
                        switch (i) {
                            case 0:
                                SQLiteDatabase database = sqlites.getReadableDatabase();
                                database.delete("cou", "id=?",new String[] { count.getId()+"" });
                                initArrayList();
                                break;
                            default:
                                break;
                        }
                    }
                });

                builder.show();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initArrayList();
    }

    //处理添加收支按钮的事件
    public void add(View view){
        //显示传输
        Intent intent = new Intent(MainActivity.this,AddPaymentActivity.class);
        startActivity(intent);
    }
    //处理查看收入按钮的事件
    public void lookIncome(View view){
        if ("隐藏详情".equals(see_list.getText().toString())){
            listView.setVisibility(View.INVISIBLE);
            see_list.setText("收支详情");
        }else {
            listView.setVisibility(View.VISIBLE);
            see_list.setText("隐藏详情");
        }
    }
    public void initArrayList(){
        totalPay=0;
        totalIncome=0;
        after=0;
        arrayList.clear();
        SQLiteDatabase database = sqlites.getReadableDatabase();
        Cursor cursor=database.query("cou",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            //获取游标中的数据
            id = Integer.parseInt(cursor.getString(0));
            type = Integer.parseInt(cursor.getString(1));
            name = cursor.getString(2);
            money = Double.parseDouble(cursor.getString(3));
            if (type == 1) {
                count = new Count(id,type,name,money);
                arrayList.add(count);
                totalIncome +=money;
            }else {
                count =new Count(id,type,name,money*(-1));
                arrayList.add(count);
                totalPay +=money;
            }
        }

        after = totalIncome-totalPay;
        //将计算后的数保留两位小数后输出
        after=Math.round(after*100)/100.00;
        totalIncome=Math.round(totalIncome*100)/100.00;
        totalPay=Math.round(totalPay*100)/100.00;
        database.close();
        //初始化适配器
        incomeAdapter = new IncomeAdapter(MainActivity.this,arrayList);
        listView.setAdapter(incomeAdapter);
        textViewPay.setText(totalPay+"");
        textViewIncome.setText(totalIncome+"");
        textViewafter.setText(after+"");
    }
}
