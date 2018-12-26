package com.bwei.fan;


import android.app.Activity;
import android.view.View;

import com.bwei.fan.annotation.Annote;
import com.bwei.fan.annotation.Clicks;

import java.lang.reflect.Field;

public class IdInjectUtil {
    public static void inject(Activity activity){
        Class clas= activity.getClass();
         Field[] fields = clas.getFields();
         if (fields!=null&& fields.length>0){
             for (Field fl:fields){
                 Annote an = fl.getAnnotation(Annote.class);
                 if (an!=null){
                     View view = activity.findViewById(an.value());
                     if (view!=null){
                         fl.setAccessible(true);
                         try {
                             fl.set(activity,view);
                         } catch (IllegalAccessException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }
         }
        if (fields!=null&& fields.length>0){
            for (Field fl:fields){
                Clicks cl = fl.getAnnotation(Clicks.class);
                if (cl!=null){
                    View view = activity.findViewById(cl.id());
                    view.setOnClickListener((View.OnClickListener)activity);
                    if (view!=null){
                        fl.setAccessible(true);
                        try {
                            fl.set(activity,view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
