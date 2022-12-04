package org.wintmain.toast_demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.wintmain.library.style.ToastBlackStyle;
import org.wintmain.library.toast.ToastUtils;
import org.wintmain.library.style.ToastWhiteStyle;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-11-09 23:46:07
 */
public class ToastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button button_7 = (Button) findViewById(R.id.show7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(ToastUtils.isNotificationEnabled(getApplicationContext()));
            }
        });
    }

    public void show1(final View v) {
        ToastUtils.show("我是Toast");
    }

    public void show2(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.show("我是从子线程中弹出的Toast");
            }
        }).start();
    }

    public void show3(View v) {
        ToastUtils.initStyle(new ToastWhiteStyle());
        ToastUtils.show("动态切换Toast白色样式成功");
    }

    public void show4(View v) {
        ToastUtils.initStyle(new ToastBlackStyle());
        ToastUtils.show("动态切换Toast黑色样式成功");
    }


    public void show5(View v) {
        ToastUtils.show(this);
    }

    public void show6(View v){
        ToastUtils.setView(this,R.layout.toast_custom_view);
        ToastUtils.show("我是自定义Toast");
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        //如果通知栏的权限被手动关闭了
//        if(!ToastUtils.isNotificationEnabled(this) && "XToast".equals(ToastUtils.getToast().getClass().getSimpleName())){
//            Log.v("TAG","onRestart");
//            ToastUtils.init(getApplication());
//            recreate();
//            ToastUtils.show("检查到你手动关闭了。需要重启应用");
//        }
//    }
}
