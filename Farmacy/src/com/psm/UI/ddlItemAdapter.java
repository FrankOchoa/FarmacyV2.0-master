package com.psm.UI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.psm.farmacy.R;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

public class ddlItemAdapter  extends BaseAdapter{

	
	private List<drwItem> list;
	protected Activity activity;
	
	public ddlItemAdapter(Activity activity,ArrayList<drwItem> array)
	{
		this.activity=activity;
		this.list=array;
	}
	
	@SuppressLint("InflateParams")
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
		if(convertView == null) {
		      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		      vi = inflater.inflate(R.layout.item_menu_drawer, null);
		    }
		    drwItem item=list.get(position);
		    ImageView image=(ImageView)vi.findViewById(R.id.iconImage);
		    image.setImageDrawable(item.getIcom());
		    TextView text=(TextView) vi.findViewById(R.id.iconLabel);
		    text.setText(item.getLabel());
		return vi;//super.getDropDownView(position, convertView, parent);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View vi=convertView;
		 
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.item_menu_drawer, null);
	    }
	    drwItem item=list.get(position);
	    ImageView image=(ImageView)vi.findViewById(R.id.iconImage);
	    image.setImageDrawable(item.getIcom());
	    TextView text=(TextView) vi.findViewById(R.id.iconLabel);
	    text.setText(item.getLabel());
		return vi;
	}

}
