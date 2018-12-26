package com.bwei.fan.bean;

import android.util.Log;

public class Student {
   /* private static final String TAG = "Student+++++";
    private String name;
    private int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
   private String show(String message){
       Log.d(TAG, "show: +++"+name+","+"age"+","+message);
        return "abc";
   }*/
   private static final String TAG = "~~~~Student~~~~";
    private String studentName;
    private int studentAge;

    private Student(String studentName){
        this.studentName = studentName;
    }

    private String show(String message){
        Log.d(TAG, "show: " + studentName + "," + studentAge + ","+ message);
        return "abc";
    }

   public Student(){

   }
}
