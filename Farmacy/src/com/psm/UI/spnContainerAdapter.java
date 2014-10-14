package com.psm.UI;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.psm.Model.*;
import com.psm.farmacy.R;

@SuppressLint("InflateParams")
public class spnContainerAdapter extends BaseAdapter{

	private List<Container> list;
	protected Activity activity;
	
	public spnContainerAdapter(Activity activity,List<Container> list)
	{
		this.activity=activity;
		this.list=list;
	}
	
	@Override
	public int getCount() {		
		return list.size();
	}

	@Override
	public Object getItem(int index) {		
		return list.get(index);
	}

	@Override
	public long getItemId(int index) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		
		if(convertView == null) {
		      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		      vi = inflater.inflate(R.layout.item_container_spn, null);
		    }
		TextView lblContainer=(TextView) vi.findViewById(R.id.lblType);
		ImageView imgContainer=(ImageView)vi.findViewById(R.id.imgIcon);
		Container cont= list.get(position);
		lblContainer.setText(cont.getContainer());
		if(cont.getIcon().equals("ax"))
		{
			imgContainer.setImageResource(R.drawable.ax);
		}
		if(cont.getIcon().equals("bx"))
		{
			imgContainer.setImageResource(R.drawable.bx);
		}
		if(cont.getIcon().equals("cx"))
		{
			imgContainer.setImageResource(R.drawable.cx);
		}
		if(cont.getIcon().equals("dx"))
		{
			imgContainer.setImageResource(R.drawable.dx);
		}
		if(cont.getIcon().equals("ex"))
		{
			imgContainer.setImageResource(R.drawable.ex);
		}
		if(cont.getIcon().equals("fx"))
		{
			imgContainer.setImageResource(R.drawable.fx);
		}
		if(cont.getIcon().equals("gx"))
		{
			imgContainer.setImageResource(R.drawable.gx);
		}
		if(cont.getIcon().equals("hx"))
		{
			imgContainer.setImageResource(R.drawable.hx);
		}
		if(cont.getIcon().equals("ix"))
		{
			imgContainer.setImageResource(R.drawable.ix);
		}
		if(cont.getIcon().equals("jx"))
		{
			imgContainer.setImageResource(R.drawable.jx);
		}
		if(cont.getIcon().equals("kx"))
		{
			imgContainer.setImageResource(R.drawable.kx);
		}
		if(cont.getIcon().equals("mx"))
		{
			imgContainer.setImageResource(R.drawable.mx);
		}				
		return vi;
	}

}
