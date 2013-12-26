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
版权所有：版权所有(C)2013，固派软件
文件名称：com.goopai.shenma.custom.FragmentRadioGroup.java
系统编号：
系统名称：Shenma
模块编号：
模块名称：
设计文档：
创建日期：2013-12-23 下午9:35:14
作 者：陆键霏
内容摘要：自定义RadioGroup
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class FragmentRadioGroup extends RadioGroup {
	String tag = "FragmentRadioGroup";
	// 每个页面的Fragment
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
		if(fragments.size()==1){ //第一项
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
	//片适配器
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


