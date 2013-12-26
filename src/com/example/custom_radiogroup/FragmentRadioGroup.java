package com.example.custom_radiogroup;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.goopai.shenma.custom.FragmentRadioGroup.java
ϵͳ��ţ�
ϵͳ���ƣ�Shenma
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-23 ����9:35:14
�� �ߣ�½����
����ժҪ���Զ���RadioGroup
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class FragmentRadioGroup extends RadioGroup {
	String tag = "FragmentRadioGroup";
	// ÿ��ҳ���Fragment
    List<Fragment> fragments = new ArrayList<Fragment>();
    
    MyFragmentAdapter mMyFragmentAdapter = null;
    
    ViewPager viewpager = null;
    
    float width = 5;
    int color = Color.RED;
	public MyFragmentAdapter getAdapter() {
		return mMyFragmentAdapter;
	}

	public FragmentRadioGroup(Context context) {
		this(context,null);
	}

	public FragmentRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public void init(FragmentActivity activity,ViewPager viewpager){
		mMyFragmentAdapter =new MyFragmentAdapter(activity.getSupportFragmentManager(), fragments);
		this.viewpager = viewpager;
		this.viewpager.setAdapter(mMyFragmentAdapter);
		this.viewpager.setOnPageChangeListener(mOnPageChangeListener);
	}
	public void setColor(int color){
		this.color = color;
	}
	public void setBottomLineWidth(float w){
		this.width = w;
	}
	public void addFragment(Fragment fragment,String tabTitle){
		this.fragments.add(fragment);
		BaseRadioButton radioBtn = new BaseRadioButton(getContext());  
		radioBtn.setId(fragments.size()-1);
		print(tag,"fragments.size="+fragments.size());
		radioBtn.setButtonDrawable(getResources().getDrawable(android.R.color.transparent)); 
		radioBtn.setPadding(10, 0, 10, 0);
		radioBtn.setClickable(true);
		radioBtn.setGravity(Gravity.CENTER);
		radioBtn.setPainterColor(this.color);
		radioBtn.setPainterWidth(this.width);
		if(fragments.size()==1){ //��һ��
			radioBtn.setChecked(true);
		}
		RadioGroup.LayoutParams lp_radiobtn = new RadioGroup.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT); 
		lp_radiobtn.weight = 1;
		final int id = radioBtn.getId();
		radioBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				viewpager.setCurrentItem(id,true);
			}
		});
		radioBtn.setLayoutParams(lp_radiobtn);
		radioBtn.setText(tabTitle);
	    this.addView(radioBtn);
	}
	//Ƭ������
	class MyFragmentAdapter extends FragmentPagerAdapter
	{
		List<Fragment> frags;
		public MyFragmentAdapter(FragmentManager fm, List<Fragment> frag)
		{
			super(fm);
			this.frags = frag;
		}
		@Override
		public Fragment getItem(int arg0)
		{
			return frags.get(arg0);
		}
		@Override
		public int getCount()
		{
			return frags.size();
		}
	}
	OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener(){
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			print(tag,"onPageSelected arg="+arg0);
			selectTab(arg0);
		}
	};
	private void selectTab(int index) {
		for(int i=0;i<getChildCount();i++){
			if(getChildAt(i) instanceof RadioButton){
				RadioButton radioBtn = (RadioButton)getChildAt(i);
//				print(tag,"select="+radioBtn.getId()+" text="+radioBtn.getText().toString());
				if(radioBtn.getId() == index){
					radioBtn.setChecked(true);
				}
			}
		}
	}
	
	void print(String tag,String msg){
		Log.d(tag, msg);
	}
}


