package com.bwei.fan.annotation;

import android.support.annotation.IdRes;

import java.lang.annotation.Retention;


public @interface Annote {
    @IdRes int value();
}
