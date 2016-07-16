package com.example.lifesupport.FinanceManager;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lifesupport.R;

/**
 * Created by Administrator on 2016/7/14.
 */
public class AddPaymentActivity extends Activity {
    private RadioButton radioButton_sr;
    private EditText editText_name,editText_money;
    //获取收支类型，true标识选择了收入按钮，否则选择了支出按钮
    private int type;
    private String name;
    private double money;
    private TextInputLayout ntil,mtil;
    private  MySqlite mySqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpayment_layout);
         ntil = (TextInputLayout) findViewById(R.id.namewrapper);
         mtil = (TextInputLayout) findViewById(R.id.monneywrapper);
        radioButton_sr = (RadioButton)findViewById(R.id.rb_sr);

        //收入
        editText_name = (EditText)findViewById(R.id.et_name);
        editText_money = (EditText)findViewById(R.id.et_money);
        ntil.setHint("支出名称");
        mtil.setHint("金额");
        mySqlite = new MySqlite(this);
    }

    public void submit(View view){
        //获取数据，并判断数据是否合法
        type = radioButton_sr.isChecked()?1:0;
        name = editText_name.getText().toString();
        //数据无效
        if (editText_money.getText().toString().length() == 0 || name.length() == 0){
            Toast.makeText(AddPaymentActivity.this,"请输入合法数据",Toast.LENGTH_SHORT).show();
        }else {
            money = Double.parseDouble(editText_money.getText().toString());
            //存入数据库
            ContentValues contentValues = new ContentValues();
            contentValues.put("type",type);
            contentValues.put("name",name);
            contentValues.put("money",money);
            SQLiteDatabase database = mySqlite.getReadableDatabase();
            database.insert("cou",null,contentValues);
            Toast.makeText(AddPaymentActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void cancle(View view){
        finish();
    }

}
