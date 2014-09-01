package com.psm.UI;

import java.util.ArrayList;
import java.util.List;
import com.psm.farmacy.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class drwItemAdapter  extends BaseAdapter{

	private List<drwItem> list;
	protected Activity activity;
	
	public drwItemAdapter(Activity activity,ArrayList<drwItem> array)
	{
		this.activity=activity;
		this.list=array;
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
		//list.get(position).getLabel();
		return position;
	}
	
	public Drawable getImage(int position)
	{
		return list.get(position).getIcom();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		View vi=convertView;
		  
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.drw_item, null);
	    }
	    drwItem item=list.get(position);
	    ImageView image=(ImageView)vi.findViewById(R.id.iconImage);
	    image.setImageDrawable(item.getIcom());
	    TextView text=(TextView) vi.findViewById(R.id.iconLabel);
	    text.setText(item.getLabel());
		return vi;
	}
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getDropDownView(position, convertView, parent);
		View vi=convertView;
		  
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.drw_item, null);
	    }
	    drwItem item=list.get(position);
	    ImageView image=(ImageView)vi.findViewById(R.id.iconImage);
	    image.setImageDrawable(item.getIcom());
	    TextView text=(TextView) vi.findViewById(R.id.iconLabel);
	    text.setText(item.getLabel());
		return vi;
	}

	
	
}
