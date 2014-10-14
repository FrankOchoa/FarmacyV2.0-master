package com.psm.UI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.psm.Model.*;
import com.psm.farmacy.R;

public class itemListLastAdapter  extends BaseAdapter {
	private List<Take> takes;
	protected Activity activity;
	private ImageView icono;
	private TextView txtMedication;
	private TextView txtActive;
	private TextView txtNameTime;
	
	public itemListLastAdapter(Activity activity,List<Take> tomas)
	{
		this.activity=activity;
		this.takes=tomas;
	}

	@Override
	public int getCount() {		
		return takes.size();
	}

	@Override
	public Object getItem(int index) {
		return takes.get(index);
	}

	@Override
	public long getItemId(int arg0) {		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		
		if(convertView == null) {
		      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		      vi = inflater.inflate(R.layout.item_schedule, null);
		    }
		
		Take toma= takes.get(position);
		txtMedication=(TextView) vi.findViewById(R.id.txtMedication);
		txtActive=(TextView) vi.findViewById(R.id.txtActiveName);
		icono=(ImageView)vi.findViewById(R.id.imgIconX);
		txtNameTime=(TextView) vi.findViewById(R.id.txtNameTime);
		txtMedication.setText(toma.getMedicina());		
		txtActive.setText(toma.getTratamiento());
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fecha=df.format(toma.getFecha());		
		txtNameTime.setText(toma.getUsuario()+"/"+ fecha);
		String icon=toma.getIcon();
		if(icon.equals("ax"))
		{
			icono.setImageResource(R.drawable.ax);
		}
		if(icon.equals("bx"))
		{
			icono.setImageResource(R.drawable.bx);
		}
		if(toma.getIcon().equals("cx"))
		{
			icono.setImageResource(R.drawable.cx);
		}
		if(icon.equals("dx"))
		{
			icono.setImageResource(R.drawable.dx);
		}
		if(icon.equals("ex"))
		{
			icono.setImageResource(R.drawable.ex);
		}
		if(icon.equals("fx"))
		{
			icono.setImageResource(R.drawable.fx);
		}
		if(icon.equals("gx"))
		{
			icono.setImageResource(R.drawable.gx);
		}
		if(icon.equals("hx"))
		{
			icono.setImageResource(R.drawable.hx);
		}
		if(icon.equals("ix"))
		{
			icono.setImageResource(R.drawable.ix);
		}
		if(icon.equals("jx"))
		{
			icono.setImageResource(R.drawable.jx);
		}
		if(icon.equals("kx"))
		{
			icono.setImageResource(R.drawable.kx);
		}
		if(icon.equals("mx"))
		{
			icono.setImageResource(R.drawable.mx);
		}		
		return vi;
	}

}
