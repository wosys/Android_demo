package org.wintmain.toast_demo;

import android.app.Application;

import org.wintmain.library.toast.ToastUtils;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-11-09 23:40:50
 */
public class ToastApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //在Application中初始化Toast
//        ToastUtils.init(getApplicationContext());
        ToastUtils.init(this);
    }
}
