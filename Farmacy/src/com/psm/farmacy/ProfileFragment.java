package com.psm.farmacy;

import java.util.ArrayList;
import java.util.List;

import com.psm.Database.Procedures;
import com.psm.Model.User;
import com.psm.UI.UserListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileFragment extends BaseFragment{
	private View vi;
	private List<User> usuarios = new ArrayList<User>();
	private ListView lstUsers;
	private int idSeleccionado = 0;
	private FragmentActivity myContext;
	//private OnItemLongClickListener lstUsersListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
		LoadDatabase(getActivity());		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Procedures pr = new Procedures(container.getContext());
		usuarios = pr.lstUsuarios();
		vi= inflater.inflate(R.layout.fragment_profile, container, false);
		lstUsers=(ListView) vi.findViewById(R.id.profilelstUsers);
		lstUsers.setAdapter(new UserListAdapter(getActivity(), usuarios));
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
			
			break;
		case 1:
			Fragment frag= new Fragment();
			frag= new ProfileAddFragment(true, idSeleccionado);
			FragmentManager fragmentManager = myContext.getSupportFragmentManager();    
			FragmentTransaction FT =fragmentManager.beginTransaction();
			FT.replace(R.id.container, frag);
			FT.commit();
			break;
		case 2 :
			pr.deleteUsuario(idSeleccionado);
			idSeleccionado = 0;
			usuarios = pr.lstUsuarios();
			lstUsers.setAdapter(new UserListAdapter(getActivity(), usuarios));
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
		lstUsers.setOnItemLongClickListener(LongClick);
	}
	@Override
	public void onAttach(Activity activity) {
		myContext=(FragmentActivity) activity;
		super.onAttach(activity);
	}
	public OnItemLongClickListener LongClick = new OnItemLongClickListener() {
		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View v,
				int position, long arg3) {
			Toast.makeText(getActivity(),"" + usuarios.get(position).getId() +
					usuarios.get(position).getUsuario() + 
					usuarios.get(position).getEdad() +
					usuarios.get(position).getSexo() 
					,Toast.LENGTH_SHORT ).show();
			idSeleccionado = usuarios.get(position).getId();
			return false;
		}
	};  
}