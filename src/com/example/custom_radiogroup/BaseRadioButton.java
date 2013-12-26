package com.example.custom_radiogroup;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RadioButton;

/*
版权所有：版权所有(C)2013，固派软件
文件名称：com.goopai.shenma.view.BaseRadioButton.java
系统编号：
系统名称：Shenma
模块编号：
模块名称：
设计文档：
创建日期：2013-12-24 上午12:25:45
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class BaseRadioButton extends RadioButton {

	private Paint mPaint=new Paint();
	private int selectedColor = Color.RED;
	private int unselectedColor = Color.BLACK;
	public void setPainterColor(int color){
		mPaint.setColor(color);
	}
	
	public void setPainterWidth(float w){
		mPaint.setStrokeWidth(w);
	}
	
	public BaseRadioButton(Context context) {
		this(context,null);
	}
	public BaseRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	@Override
	public void setChecked(boolean checked) {
		super.setChecked(checked);
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(isChecked()){
			//画底线  
			canvas.drawLine(1, this.getHeight() - 1,
        				this.getWidth() - 2,this.getHeight() - 1, mPaint);
			
			setTextColor(selectedColor);
		}else{
			setTextColor(unselectedColor);
		}
	}
}


