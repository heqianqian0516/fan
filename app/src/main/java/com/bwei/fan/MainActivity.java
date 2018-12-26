package com.bwei.fan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.fan.annotation.Annote;
import com.bwei.fan.annotation.Clicks;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity+++++";
    @Annote(R.id.btn_aa)
    Button btn_aa;
  /* @Annote(R.id.btn_zhu)*/
   @Clicks(id = R.id.btn_click)
   Button btn_click;

  /* @Annote(R.id.main_title)
   TextView main_title;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IdInjectUtil.inject(this);
       /* main_title.setText("这是一个注解测试");*/
        initView();

     /*   try {
            //通过字符串获取class对象
            Class studentClass=Class.forName("com.bwei.fan.bean.Student");
            //获取声明的构造方法，传入所需要的类名
            //Constructor studentConstructor = studentClass.getDeclaredConstructor(String.class);
            Constructor studentConstructor = studentClass.getDeclaredConstructor(String.class);

            studentConstructor.setAccessible(true);
             Object student = studentConstructor.newInstance("NameA");
             //获取声明的字段传入字段
             Field studentAge = studentClass.getDeclaredField("studentAge");
             studentAge.setAccessible(true);
             studentAge.set(student,10);
             Method show = studentClass.getDeclaredMethod("show", String.class);
             show.setAccessible(true);
             Object result = show.invoke(student, "message");
            Log.d(TAG, "result: " + (String) result);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            Class studentClass = Class.forName("com.bwei.fan.bean.Student");
            //2.获取声明的构造方法，传入所需参数的类名，如果有多个参数，用','连接即可
            Constructor studentConstructor = studentClass.getDeclaredConstructor(String.class);
            //如果是私有的构造方法，需要调用下面这一行代码使其可使用，公有的构造方法则不需要下面这一行代码
            studentConstructor.setAccessible(true);
            //使用构造方法的newInstance方法创建对象，传入构造方法所需参数，如果有多个参数，用','连接即可
            Object student = studentConstructor.newInstance("NameA");

            //3.获取声明的字段，传入字段名
            Field studentAgeField = studentClass.getDeclaredField("studentAge");
            //如果是私有的字段，需要调用下面这一行代码使其可使用，公有的字段则不需要下面这一行代码
            studentAgeField.setAccessible(true);
            //使用字段的set方法设置字段值，传入此对象以及参数值
            studentAgeField.set(student,10);

            //4.获取声明的函数，传入所需参数的类名，如果有多个参数，用','连接即可
            Method studentShowMethod = studentClass.getDeclaredMethod("show",String.class);
            //如果是私有的函数，需要调用下面这一行代码使其可使用，公有的函数则不需要下面这一行代码
            studentShowMethod.setAccessible(true);
            //使用函数的invoke方法调用此函数，传入此对象以及函数所需参数，如果有多个参数，用','连接即可。函数会返回一个Object对象，使用强制类型转换转成实际类型即可
            Object result = studentShowMethod.invoke(student,"message");
            Log.d(TAG, "result: " + (String) result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //1.
            Class studentClass1=Class.forName("com.bwei.fan.bean.Student");
            //2.获取所有声明的构造方法
            Constructor[] declaredConstructorList = studentClass1.getDeclaredConstructors();
            for (Constructor declaredConstructor:declaredConstructorList){
                Log.d(TAG, "declaredConstructor:++++++"+declaredConstructor);
            }
          //获取所有的共有的构造方法
             Constructor[] constructor = studentClass1.getConstructors();
            for (Constructor constructor1:constructor){
                Log.d(TAG, "constructor1:+++++++ "+constructor1);
            }
            //3.获取所有的声明字段
             Field[] declaredFields = studentClass1.getDeclaredFields();
            for (Field declared:declaredFields){
                Log.d(TAG, "declared: +++++"+declaredFields);
            }
            //获取所有的共有字段
             Field[] fields = studentClass1.getFields();
            for (Field field:fields){
                Log.d(TAG, "field: +++++"+fields);
            }
            //4.获取所有的声明函数
             Method[] declaredMethods = studentClass1.getDeclaredMethods();
            for (Method declaredMethod:declaredMethods){
                Log.d(TAG, "declaredMethod: +++++"+declaredMethods);
            }
            //获取所有的函数
             Method[] methods = studentClass1.getMethods();
            for (Method method:methods){
                Log.d(TAG, "method: +++++"+methods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initView() {
       btn_aa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aa:
                Toast.makeText(MainActivity.this,"点击找到id",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_click:
                Toast.makeText(MainActivity.this,"这是点击事件",Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
