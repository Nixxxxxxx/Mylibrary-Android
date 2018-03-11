package com.kopykat.downloadutil;

import android.util.Log;

/**
 * Created by zero on 11.03.18.
 */

public class LogDebug {
    private  static final  String TAG = "Testing custom library";
    public  static  void  d(String message){
        Log.d(TAG, message);//idividual gradle import
    }
}
