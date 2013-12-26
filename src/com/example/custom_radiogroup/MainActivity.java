package com.example.custom_radiogroup;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager viewPager = null;
	FragmentRadioGroup mFragmentRadioGroup = null;
	FragmentTab mCouponTab1 = new FragmentTab();
	FragmentTab mCouponTab2 = new FragmentTab();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		mFragmentRadioGroup = (FragmentRadioGroup)findViewById(R.id.tabGroup);
		mFragmentRadioGroup.init(this,viewPager);
		
		mCouponTab1.msg = "tab1";
		mCouponTab2.msg = "tab2";
		mFragmentRadioGroup.addFragment(mCouponTab1, "tab1");
		mFragmentRadioGroup.addFragment(mCouponTab2, "tab2");
		viewPager.setAdapter(mFragmentRadioGroup.getAdapter());
	}
	
}
