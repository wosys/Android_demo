package org.wintmain.library.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.wintmain.library.R;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-11-15 23:00:41
 */
public final class XToast extends Toast implements Runnable{

    private Handler mHandler = new Handler(Looper.getMainLooper());//吐司处理消息线程
    private TextView mTextView;//吐司消息View
    private CharSequence mContext;//吐司显示的文本

    XToast(Context context){
        super(context);
    }

    @Override
    public void setView(View view) {
        super.setView(view);
        mTextView = (TextView) view.findViewById(R.id.toast_main_text_view_id);
        if(mTextView != null){
            return;
        } else if(view instanceof TextView){
            mTextView = (TextView) view;
            return;
        }else if(view instanceof ViewGroup){
            this.mTextView = getTextView((ViewGroup) view);
            if(this.mTextView!=null) return;
        }
        //布局中必须包含一个Textview作为Message对象
        throw new IllegalArgumentException("The layout must contain a TextView");

    }

    /*
     * 递归获取ViewGroup中的TextView对象
     */
    private static TextView getTextView(ViewGroup group) {
        for(int i=0;i<group.getChildCount();i++){
            View view = group.getChildAt(i);
            if(view instanceof TextView){
                return (TextView) view;
            }else if(view instanceof ViewGroup){
                TextView textView = getTextView((ViewGroup) view);
                if(textView!=null) return textView;
            }
        }
        return null;
    }

    @Override
    public void setText(CharSequence s) {
//        if(mTextView!=null){
//            mTextView.setText(s);
//        }
//        else {
//            super.setText(s);
//        }
        //记录本次欲显示的文本
        mContext = s;
    }

    @Override
    public void show() {
        mHandler.removeCallbacks(this);//移除之前显示吐司的任务
        mHandler.postDelayed(this,300);//延时添加显示
    }

    @Override
    public void run() {
        //显示吐司文本
        mTextView.setText(mContext);
        super.show();
    }

    @Override
    public void cancel(){
        //移除之前的吐司显示
        mHandler.removeCallbacks(this);
        // 取消显示
        super.cancel();
    }
}
