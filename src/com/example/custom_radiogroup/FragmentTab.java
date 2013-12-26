package com.example.custom_radiogroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
版权所有：版权所有(C)2013，固派软件
文件名称：com.example.custom_radiogroup.FragmentTa.java
系统编号：
系统名称：custom_radiogroup
模块编号：
模块名称：
设计文档：
创建日期：2013-12-25 下午11:09:01
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class FragmentTab extends Fragment{
	
	public String msg;
	
	TextView txt_msg=null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragment, container, false);
		txt_msg = (TextView)view.findViewById(R.id.txt_msg);
		txt_msg.setText(msg);
		return view;
	}
	
}


