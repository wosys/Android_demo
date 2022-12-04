package org.wintmain.library.toast;

/**
 *    desc   : 默认样式接口
 */
public interface IToastStyle {

    public int getGravity();//吐司的重心
    public int getXOffset();//X轴偏移
    public int getYOffset();//Y轴偏移
    int getZ();//吐司Z轴作标

    public int getCornerRadius();//圆角大小
    public int getBackgroundColor();//背景颜色

    public int getTextColor();//文本颜色
    public float getTextSize();//文本大小
    public int getMaxLines();//最大行数

    public int getPaddingLeft();//左边内边距
    public int getPaddingTop();//顶部内边距
    public int getPaddingRight();//右边内边距
    public int getPaddingBottom();//底部内边距
}