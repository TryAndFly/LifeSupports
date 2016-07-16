package com.example.lifesupport.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lifesupport.R;

/**
 * Created by Administrator on 2016/7/14.
 */
public class MainActivity  extends AppCompatActivity {
    private String string_num,string_fuhao,string_danfuhao,string_temp;
    private double num1,num2,num_temp;
    private Button button;
    private TextView textView_out;
    private boolean tag_init,tag_point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        textView_out = (TextView) findViewById(R.id.outPut);
        init();
    }

    public void init(){
        //初始化
        textView_out.setText("");
        string_num =" ";
        string_fuhao = " ";
        string_danfuhao=" ";
        //运算的两个数
        num1=0;
        num2=0;
        tag_point=false;//判断小数点输入状态
        tag_init = true;//判断是否清屏
    }
    //处理数字符号
    public  void num(View view){
        button =(Button)view;
        //获取输入的字符

        //处理输入小数点的情况
        if (".".equals(button.getText().toString())){
            //判断是否已经存在小数点
            tag_point = textView_out.getText().toString().contains(".");
            if (tag_point) {
                return;
            }
            //如果小数点前没有数，则加零
            if (" ".equals(string_num)) {
                string_num = "0";
            }
        }

        if(tag_init){
            string_num +=  button.getText().toString();
        }else {
            string_num = button.getText().toString();
            tag_init=true;
        }
        textView_out.setText(string_num);
    }

    //处理四则运算符
    public  void fuhao(View view){
        if ("".equals(textView_out.getText().toString())){//没有任何输入
            return;
        }
        button = (Button)view;
        //获取输入的符号并存储运算符号.
        string_fuhao = button.getText().toString();
        //将数据存入第一个数据中
        num1 = Double.parseDouble(textView_out.getText().toString());
        string_num = " ";
    }

    //处理计算结果
    public void calculat(View view){
        if ("".equals(textView_out.getText().toString())){//没有任何输入
            return;
        }
        //输入等号后，先获取当前数据
        num2 = Double.parseDouble(textView_out.getText().toString());
        //获取之前的数据并运算
        if ("-".equals(string_fuhao)){
            num1 -=num2;
        }else if ("+".equals(string_fuhao)){
            num1 +=num2;
        }else if ("*".equals(string_fuhao)){
            num1 *=num2;
        }else{
            num1 /=num2;
        }
        //将计算后的数保留三位小数后输出
        num1=Math.round(num1*1000)/1000.000;
        textView_out.setText(String.valueOf(num1));
        //将数据清空
        tag_init = false;
    }

    //计算单符号运算符
    public void danfuhao(View view){
        button = (Button)view;
        if ("".equals(textView_out.getText().toString())){//没有任何输入
            return;
        }
        //单符号直接获取当前数据进行处理
        string_temp = textView_out.getText().toString();
        string_danfuhao = button.getText().toString();
        num_temp = Double.parseDouble(string_temp);
        switch (string_danfuhao){
            case "%"://化成百分数
                num_temp = num_temp/100.0;
                break;
            case "√":
                num_temp = Math.sqrt(num_temp);
                break;
            case "1/x":
                num_temp=1.0/num_temp;
                break;
            default:
                num_temp = num_temp*-1;
                break;
        }
        //将计算后的数保留三位小数后输出
        num_temp=Math.round(num_temp*1000)/1000.000;
        string_temp = String.valueOf(num_temp);
        textView_out.setText(string_temp);
        tag_init = false;
    }

    //清除
    public void clear(View view){
        textView_out.setText("");
        init();
    }

    //退格
    public void back(View view){
        string_temp=textView_out.getText().toString();
        if (string_temp.length() < 1)return;
        string_temp=string_temp.substring(0,string_temp.length()-1);
        textView_out.setText(string_temp);
        string_num=string_temp;
    }

}
