package com.psm.UI;

import java.util.ArrayList;
import java.util.List;

import com.psm.Model.User;
import com.psm.farmacy.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserListAdapter extends BaseAdapter {

	private List<User> listUser = new ArrayList<User>();
	protected Activity activity;
	
	
	public UserListAdapter(Activity activity, List<User> usuarios){
		this.listUser = usuarios;
		this.activity = activity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listUser.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listUser.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return listUser.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
		  
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.userlist_item, null);
	    }
	    User item=listUser.get(position);
	    TextView text=(TextView) vi.findViewById(R.id.tvUsername);
	    text.setText(item.getUsuario());
		return vi;
	}

}
