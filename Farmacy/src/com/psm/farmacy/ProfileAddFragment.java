package com.psm.farmacy;

import com.psm.Database.Procedures;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileAddFragment extends Fragment{

	private View vi;
	private EditText  txtName;
	private EditText  txtAge;
	private Button btnSave;
	private FragmentActivity myContext;
	private RadioGroup radioGGen;

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {		
		//super.onCreateOptionsMenu(menu, inflater);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		vi= inflater.inflate(R.layout.fragment_profile_add, container, false);	
		txtName=(EditText)vi.findViewById(R.id.profiletxtName);
		txtAge=(EditText)vi.findViewById(R.id.profiletxtAge);
		btnSave=(Button)vi.findViewById(R.id.profilebtnSave);
		radioGGen=(RadioGroup) vi.findViewById(R.id.radioGGen);
		CreateListener();
		return vi;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		myContext=(FragmentActivity) activity;
		super.onAttach(activity);
	}

	public void CreateListener()
	{
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				String nombre="";
				String edad="0";
				String sexo="H";
				if(txtName.getText().toString().equals(""))
				{
					Toast.makeText(getActivity(),"Nombre requerido",Toast.LENGTH_SHORT).show();
				}
				else
				{
					nombre=txtName.getText().toString();
					edad= txtAge.getText().toString()==""||
							txtAge.getText().toString()==""?"0":
								 txtAge.getText().toString(); 
					
				}
				Procedures pr= new Procedures(getActivity());				
				int rdio =radioGGen.getCheckedRadioButtonId();
				if(rdio== R.id.profilerdoFemale)
				{
					sexo="M";
				}				
				if(pr.AddUsuario(nombre, edad, sexo))
				{
					Toast.makeText(getActivity(), "Actualizado", Toast.LENGTH_SHORT).show();					
				}
				else
				{
					Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
				}				
				FragmentManager fragManager = myContext.getSupportFragmentManager();
				fragManager.beginTransaction().replace(R.id.container, new ProfileFragment()).commit();				
			}
		});
	}


}
