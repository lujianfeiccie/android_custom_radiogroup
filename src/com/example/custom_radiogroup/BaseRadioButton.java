package com.example.custom_radiogroup;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RadioButton;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.goopai.shenma.view.BaseRadioButton.java
ϵͳ��ţ�
ϵͳ���ƣ�Shenma
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-24 ����12:25:45
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
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
			//������  
			canvas.drawLine(1, this.getHeight() - 1,
        				this.getWidth() - 2,this.getHeight() - 1, mPaint);
			
			setTextColor(selectedColor);
		}else{
			setTextColor(unselectedColor);
		}
	}
}


