package com.example.custom_radiogroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.example.custom_radiogroup.FragmentTa.java
ϵͳ��ţ�
ϵͳ���ƣ�custom_radiogroup
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-25 ����11:09:01
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
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


