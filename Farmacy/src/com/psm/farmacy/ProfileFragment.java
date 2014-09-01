package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;

import com.psm.Database.Procedures;
import com.psm.Model.User;
import com.psm.UI.UserListAdapter;

//import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileFragment extends Fragment{

	//private Activity actParent;
	private View vi;
	private List<User> usuarios = new ArrayList<User>();
	private ListView lstUsers;
	private OnItemLongClickListener lstUsersListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
		try
		{
			Procedures pr= new Procedures(getActivity());
			usuarios=pr.LstUsuarios();
		}
		catch(Exception ex)
		{
			Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();			
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		vi= inflater.inflate(R.layout.fragment_profile, container, false);
		lstUsers=(ListView) vi.findViewById(R.id.profilelstUsers);		
		lstUsers.setAdapter(new UserListAdapter(getActivity(), usuarios));
		//lstUsers.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,usuarios));
		registerForContextMenu(lstUsers);	
		CreateListeners();
		return vi;		
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {	
		menu.clear();		
		inflater.inflate(R.menu.profile, menu);		
	}
	

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
			case 0:
				Toast.makeText(getActivity(), "Detalles", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(getActivity(), "Editar", Toast.LENGTH_SHORT).show();
				break;
			case 2 :
				Toast.makeText(getActivity(), "Eliminar", Toast.LENGTH_SHORT).show();
				break;		
		}
		return super.onContextItemSelected(item);
	}
	

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if(v.getId()==R.id.profilelstUsers)
		{					
//			Vibrator vi = (Vibrator) getActivity().getSystemService("VIBRATOR_SERVICE");
//			vi.vibrate(3000);
		    menu.add(Menu.NONE,0,Menu.NONE,"Detalles");
		    menu.add(Menu.NONE,1,Menu.NONE,"Editar");
		    menu.add(Menu.NONE,2,Menu.NONE,"Eliminar");
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	private void CreateListeners()
	{
		lstUsers.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View v,
					int position, long arg3) {
				Toast.makeText(getActivity(),"" + usuarios.get(position).getId() +
						usuarios.get(position).getUsuario() + 
						usuarios.get(position).getEdad() +
						usuarios.get(position).getSexo() 
						,Toast.LENGTH_SHORT ).show();
				return false;
			}
		});
	}
}